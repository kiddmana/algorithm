package cn.kidd.algorithm;

import java.util.Arrays;

/**
 * 
 * @author wangding 时间：2018年7月14日 上午11:47:32 完美平方
 * 
 *         给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。 样例 给出 n = 12, 返回 3 因为 12 =
 *         4 + 4 + 4。
 * 
 *         给出 n = 13, 返回 2 因为 13 = 4 + 9。
 *         
 *         解题思路：
 *         如图所示，红色部分表示平方数，所有的完美平方数都可以看做一个普通数加上一个完美平方数，那么递推式就变为了：dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j])，
 */
public class PerfectPFDemo {

  public static void main(String[] args) {
    int num = 91;
    System.out.println(getMinPinfang(num));
  }


  public static int getMinPinfang(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 1; i * i <= n; i++) {
      dp[i * i] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; i + j * j <= n; j++) {
        dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
      }
    }

    return dp[n];
  }
}
