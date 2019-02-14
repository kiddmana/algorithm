package cn.kidd.algorithm;

import java.util.ArrayList;

/**
 * 
 * @author wangding
 * 时间：2018年7月13日 下午4:06:50
 * 最小调整数代价
 * 
 * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差小于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。

样例
对于数组[1, 4, 2, 3]和target=1，最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2。

注意
你可以假设数组中每个整数都是正整数，且小于等于100。
 */
public class LintCode {

  public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<Integer>();
    list.add(22);
    list.add(21);
    list.add(40);
    list.add(27);
    list.add(50);
    int  target = 3;
    System.out.println(MinAdjustmentCost(list, target));
  }
  
  public static int MinAdjustmentCost(ArrayList<Integer> list, int target){
    if(list.size() < 2) {
      return 0;
    }
    int m= list.size();
    long [][] dp = new long[m][101];
    int i=0;
    int j=0;
    for(i=0;i<101;i++){
      dp[0][i] = Math.abs(list.get(0) - i);
    }
    
    for(i=1;i<m;i++){
      for(j = 0;j<101;j++){
        dp[i][j] = Integer.MAX_VALUE;
        int dif = Math.abs(j - list.get(i));
        int max = Math.min(100, j + target);
        int min = Math.max(0, j-target);
        for(int k=min;k<=max;k++){
          dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + dif);
        }
      }
    }
    long ans = Integer.MAX_VALUE;
    for (j = 0; j < 101; j++) {
      ans = Math.min(ans, dp[m - 1][j]);
  }
  return(int) ans;
  }
}
