package cn.kidd.algorithm;

import java.util.Stack;

/**
 * 
 * @author wangding 时间：2019年2月15日 下午1:52:55 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 *         示例 1：
 * 
 *         输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 *         输入: "cbbd" 输出: "bb"
 */
public class MaxPalindromeDemo {

  public static void main(String[] args) {

    int len = longestPalindrome("cababa");
    System.out.println(len);
    System.out.println(longestPalindrome2("babad"));
    System.out.println("=========中间扩展============");
    System.out.println(longestPalindromeByCenter("abcddcbe"));
  }

  /***
   * 
   * @param s
   * @return 动态规划的方式来处理字符串回文数长度
   * 
   */
  public static int longestPalindrome(String s) {
    int len = s.length();
    int[][] dp = new int[len][len];
    for (int i = len - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < len; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          // 上一个索引和下一个索引的最大值
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    // 获取出最终的值大小
    return dp[0][len - 1];
  }

  /**
   * 获取最大回文字符串
   * @param s
   * @return
   */
  public static String longestPalindrome2(String s) {
    int len = s.length();
    if(s == null || len == 0){
      return s;
    }
    boolean[][] dp = new boolean[len][len];
    int max = 0;
    String res = "";
    for(int j=0;j<len;j++){
      for(int i=0;i<=j;i++){
//        再回到回文字符串，如"balalab"，判定的原则为str[0] 等于 str[6] 并且"alala"为回文字符串，
//        转换为数学表达式即是str[i] == str[j] && dp[i+1][j-1]  
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i <=2 || dp[i+1][j-1]);
        //如果是回文数
        if(dp[i][j]){
          if(j-i+1 > max){
            max = j -i +1;
            res = s.substring(i, j+1);
          }
        }
      }
    }
    // 获取出最终的值大小
    return res;
  }
  
  /**
   * 中间扩展法来获取
   * @param s
   * @return
   */
  public static String longestPalindromeByCenter(String s){
    int len = s.length();
    if(s == null || len == 0){
      return s;
    }
    int start = 0;
    int end =0;
    for(int i=0;i<s.length();i++){
      //判断奇数的回文
      int len1 = expandCenterCount(s, i, i);
      //判断偶数的回文
      int len2 = expandCenterCount(s, i, i + 1);
      int maxlen = Math.max(len1, len2);
      if(maxlen > end-start){
        start = i - (maxlen-1)/2;
        end = i + maxlen/2;
      }
    }
    
    return s.substring(start, end + 1);
  }
  /**
   * 中间扩展法来获取
   * @param s
   * @param left
   * @param right
   * @return
   */
  public static int expandCenterCount(String s,int left,int right){
    int L =left;
    int R = right;
    while(L >=0 && R < s.length() && s.charAt(R) == s.charAt(L)){
      L--;
      R++;
    }
    return R-L-1;
  }
}
