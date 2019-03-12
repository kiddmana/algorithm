package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年3月4日 下午4:04:28
 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWord {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String text = reverseWords("hello word");
    System.out.println(text);
  }
  
  public static String reverseWords(String s) {
    if(s == null){
      return "";
    }
    String[] texts = s.split(" ");
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<texts.length;i++){
      sb.append(reverseWord(texts[i])+" ");
    }
    sb.delete(sb.length()-1, sb.length());
    return sb.toString();
  }
  
  public static String reverseWord(String text){
    String str = "";
    for(int i=text.length()-1;i>=0;i--){
      str = str + text.substring(i, i+1);
    }
    return str;
  }
}
