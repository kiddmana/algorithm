package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月31日 下午7:05:36
 * 给定两个字符串，判断他们是否只差一步编辑。即两个字符串是否只有一个字符不同.
 * 如果只需要编辑一个操作，即可是两个字符串一直则返回true,否则返回false
 */
public class EditDistanceDemo {

  public static void main(String[] args) {
    System.out.println(getEditDistance("aabd","aCd"));
  }
  
  public static boolean getEditDistance(String s1,String s2){
    if(s1.length() != s2.length()) {
      return false;
    }
    int count = 0;
    for(int i=0;count<2 && i<s1.length();i++){
      String text1 = s1.substring(i, i + 1);
      String text2 = s2.substring(i, i + 1);
      if(!text1.equals(text2)) {
        count++;
      }
    }
    if(count == 1) {
      return true;
    }
    return false;
  }
}
