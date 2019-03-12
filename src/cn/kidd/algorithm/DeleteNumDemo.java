package cn.kidd.algorithm;

/**
给定n位正整数a，去掉其中任意k个数字后，剩下的数字按原次序排列组成一个新的正整数。对于给定的n和k，设计一个算法，找出剩下数字组成的新数最少的删数方案。
输入示例： 178543 4
输出： 13
输入示例： 56317 3
输出： 17
 * @author wangding
 * 时间：2018年8月28日 上午9:16:29
 *
 */
public class DeleteNumDemo {

  public static void main(String[] args) {
    int result = getMinNum(56321, 3);
    System.out.println("result = " + result);
  }
  
  /**
   * 删除数字，求最小正整数
   * @param num
   * @param n
   * @return
   */
  private static int getMinNum(int num,int n){
    StringBuilder numText = new StringBuilder(num + "");
    if(numText.length() < n){
      return 0;
    }
    StringBuilder numTempText = new StringBuilder();
    int result = Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      numTempText = new StringBuilder(numText);
      for(int j=0;j<numText.length();j++){
        result = Math.min(result, Integer.parseInt(numTempText.delete(j, j + 1).toString()));
        numTempText = new StringBuilder(numText);
      }
      numText = new StringBuilder(result + "");
    }
    return result;
  }
}
