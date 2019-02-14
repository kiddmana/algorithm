package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月14日 上午9:45:30
 * 最小重复字符串
 * 写一个方法, 给一个由 N 个字符构成的字符串 A和一个由 M 个字符构成的字符串 B, 返回 A 必须重复的次数，使得 B 是重复字符串的子串。如果 B 不可能为重复字符串的子串, 则返回 -1.

注意事项： 0 <= N <= 1000，1 <= M <= 1000

格式：

输入第一行输入一个 字符串 A，第二行输入一个字符串 B ，最后输出一个整数使得A 重复整数次后，B 是 A 重复后的字符串的子串。

A = abcd

B = cdabcdab
 */
public class RepeatStringDemo {

  public static void main(String[] args) {
    String text1 = "abcd";
    String text2 = "cdabcdab";
    System.out.println(getRepeatString(text1, text2));
  }
  public static int getRepeatString(String text1,String text2){
    boolean flag = true;
    int j = 0;
    String s = text2.substring(0, 1);
    j = text1.indexOf(s);
    if(j == -1){
      return -1;
    }
    for(int i=0;i<text2.length();i++,j++){
     String s1 = text1.substring(j,j+1);
     String s2 = text2.substring(i, i + 1);
     if(!s1.equals(s2)){
       return -1;
     }
     if(j == text1.length() -1){
       j = -1;
     }
    }
    String totalText = text1;
    for(int i=0;flag;i++){
      if(totalText.contains(text2)){
        return i;
      }
      totalText = totalText + text1;
    }
    return -1;
  }

}
