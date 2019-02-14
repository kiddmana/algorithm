package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月27日 上午9:47:33
 给定n个不同的正整数，整数k（k < = n）以及一个目标数字。

在这n个数里面找出K个数，使得这K个数的和等于目标数字，求问有多少种方案？

样例
给出[1,2,3,4]，k=2， target=5，[1,4] and [2,3]是2个符合要求的方案
f[i][k][target] = f[i-1][k][target] + f[i-1][k-1][target-arr[i]]
在(i-1)个树中选k个和(i-1)选择(k-1)使得加上最后一个选择刚好是相等的
 */
public class KSumDemo {

  public static void main(String[] args) {
    
    int[] arr = {1,2,4,3,5};
    int sum = getMaxSumCount(arr,2, 6);
    System.out.println("sum = " + sum);
  }
  
  public static int getMaxSumCount(int[] arr,int k,int target){
    int len = arr.length;
    if(arr == null || len == 0){
      return 0;
    }
    int[][] dp = new int[k+1][target+1];
    dp[0][0] = 1;
    for(int i=0;i<len;i++){
      for(int j=k;j>=1;j--){
        for(int s=target;s>=arr[i];s--){
          dp[j][s] = dp[j][s] + dp[j-1][s-arr[i]];
        }
      }
    }
    return dp[k][target];
  }
}
