package cn.kidd.algorithm;
/**
 * 
 * @author wangding
 * 时间：2018年7月24日 下午3:36:23
 题目描述：

　　找出一个序列中乘积最大的连续子序列（至少包含一个数）。

样例：
　　比如, 序列 [2,-4,3,-1,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
 */
public class MaxListSon {

  public static void main(String[] args) {
    int[] arr = {1,-2,4,-7,3,8,-2,9};
    int max = getMaxSon(arr);
    System.out.println(max);
  }
  
  public static int getMaxSon(int[] arr){
    int max = arr[0];
    int min = arr[0];
    int sum = arr[0];
    int[][] dp = new int[2][2];
    dp[0][0] = 0;
    dp[1][0] = 0;
    for(int i=1;i<arr.length;i++){
      int tempMax = max;
      int tempMin = min;
      max = Math.max(Math.max(tempMax * arr[i], tempMin * arr[i]),arr[i]);
      min = Math.min(Math.min(tempMax * arr[i], tempMin * arr[i]),arr[i]);
      //重新定义子串
      if(max == arr[i]) {
        dp[0][0] = i;
      } else {
        dp[0][1] = i;
      }
      if(min == arr[i]) {
        dp[1][0] = i;
      } else {
        dp[1][1] = i;
      }
      if(Math.max(min, max) > sum){
        sum = Math.max(min, max);
      }
    }
    System.out.println("最大子串的开始索引为"+dp[0][0]+"  --  " + dp[0][1]);
    System.out.println("最小子串的开始索引为"+dp[1][0]+"  --  " + dp[1][1]);
    return sum;
  }

}
