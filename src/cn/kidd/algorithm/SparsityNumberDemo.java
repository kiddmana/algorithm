package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月31日 下午1:51:22
一个数是稀疏数如果这个数的 二进制表示 中没有相邻的 1，给出一个 n ，找出大于或等于 n 的最小的稀疏数。 
eg. 5 (二进制表示为 101)是稀疏数，但是 6 (二进制表示为 110 ）不是稀疏数

样例： 
给出 n = 6,返回 8下一个稀疏数是8 
给出 n = 4,返回 4下一个稀疏数是4 
给出 n = 38,返回 40下一个稀疏数是40 
给出 n = 44,返回 64下一个稀疏数是64
 */
public class SparsityNumberDemo {

  public static void main(String[] args) {
    
   int minSpar = getMinSaparsityNum(38);
   System.out.println("最小稀疏数" + minSpar + " == " + Integer.toBinaryString(minSpar));
  }
  
  /**
   * java中的写法判断处理
   * @param n
   * @return
   */
  public static int getMinSaparsityNum(int n){
    boolean flag = true;
    int num = n;
    for(int i = n;flag;i++){
      String binaryNum = Integer.toBinaryString(i);
      String str = binaryNum.substring(0, 1);
      boolean sameFlag = true;
      for(int j=1;j<binaryNum.length();j++){
        String lastText = binaryNum.substring(j, j+1);
        if("1".equals(lastText) && str.equals(lastText)){
          sameFlag = false;
          break ;
        }
        str = lastText;
      }
      if(sameFlag) {
        flag = false;
        num = i;
      }
    }
    return num;
  }
  
  public static void binary2Decimal(int n) {
    for(int i = 31; i >= 0;i--){
      System.out.print(n >>> i & 1);
    }
  }
}
