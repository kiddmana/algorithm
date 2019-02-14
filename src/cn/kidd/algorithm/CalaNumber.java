package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年8月29日 下午5:26:42

   写一个函数计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
  格式：
  输入行输入一个整数 n 和一个数字 k，最后输出数字 k 在 0 到 n 中出现的次数。
  样例输入
  n = 12 
  k = 1
  样例输出
  5
 */
public class CalaNumber {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int result = getSameNumCount(88, 6);
    System.out.println("result = " + result);
  }
  
  public static int getSameNumCount(int num,int k){
    int result = 0;
    for(int i=0;i<=num;i++){
      String data = i + "";
      for(int j=0;j<data.length();j++){
        if((k + "").equals(data.substring(j, j+1))){
          result++;
        }
      }
    }
    return result;
  }

}
