package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月27日 上午11:38:32
 问题一：
 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

样例
如果有4个物品[2, 3, 5, 7]
如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
函数需要返回最多能装满的空间大小。
注意
你不可以将物品进行切割。

问题二：
二：
给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
样例
对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
注意
A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。

 */
public class MaxBagValueDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] arr = {2,3,5,7};
    int sum = getMaxWeight(arr, 13, 4);
    System.out.println(sum);
    System.out.println("==========================");
    int[] weights={2, 3, 5, 7};
    int[] values={1, 5, 2, 4};
    int maxValue = getMaxValue(14, weights, values);
    System.out.println(maxValue);
    System.out.println("======================");
    int limitSum = getUnlimitMaxvalue(14, weights, values);
    System.out.println(limitSum);
  }
  
  /**
在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

样例
如果有4个物品[2, 3, 5, 7]
如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。
如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。
函数需要返回最多能装满的空间大小。
注意
你不可以将物品进行切割。

   * @param arr 每个商品的容量数组
   * @param m 背包容量
   * @param n 商品个数
   * @return
   */
  public static int getMaxWeight(int[] arr,int m,int n){
    int[] dp = new int[m+1];
    
    for(int i=1;i<n;i++){
      for(int j=m;j>=1;j--){
        if(j>arr[i]){
          //dp[j-arr[i]] + arr[i]和dp[j-1]比较
          dp[j] = Math.max(dp[j-arr[i]] + arr[i], dp[j]);
        }
      }
    }
    return dp[m];
  }
  
  /**
   * 01背包
给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
样例
对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
注意
A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。
   */
  public static int getMaxValue(int m,int[] weight,int[] values){
    int[] maxValues = new int[m+1];
    for(int i=0;i<weight.length;i++){
      for(int j=m;j>=1;j--){
        if(j > weight[i]){
          //dp[j-arr[i]] + arr[i]和dp[j-1]比较
          maxValues[j] = Math.max(maxValues[j-weight[i]] + values[i],maxValues[j]); 
        }
      }
    }
    return maxValues[m];
  }
  
  /**
   * 完全背包，所有东西无限次获取
   * @param m
   * @param weights
   * @param values
   * @return
   */
  public static int getUnlimitMaxvalue(int m,int[] weights,int[] values){
    int[] maxValues = new int[m+1];
    for(int i=0;i<weights.length;i++){
      for(int j=0;j<=m;j++){
        if(j>=weights[i]){
          maxValues[j] = Math.max(maxValues[j-weights[i]] + values[i],maxValues[j]);  
        }
      }
    }
    return maxValues[m];
  }
}
