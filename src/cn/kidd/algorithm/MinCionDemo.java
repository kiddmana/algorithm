package cn.kidd.algorithm;

public class MinCionDemo {

  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int count = getMinCount(coins, 23);
    System.out.println(count);
  }
  
  public static int getMinCount(int[] coins,int m){
    int[] dp = new int[m+1];
    for(int i=1;i<coins.length;i++){
      dp[i] = i;
    }
    //初始化最大值
    for(int i=2;i<coins.length;i++){
      for(int j=1;j<=m;j++){
        if(j>=coins[i]){
          dp[j] = dp[j-coins[i]] + 1;
        }
      }
    }
    return dp[m];
  }

}
