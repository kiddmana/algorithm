package cn.kidd.algorithm;

public class CommonPrefix {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] texts = {"dog","racecar","car"};
    String text = longestCommonPrefix(texts);
    System.out.println(text);
  }
  public static String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0){
      return "";
    }
    String text = strs[0];
    for(int i=1;i<strs.length;i++){
      text = getCommonPreFix(text, strs[i]);
    }
    return text;
  }
  
  public static String getCommonPreFix(String s1,String s2){
    StringBuilder sb = new StringBuilder();
    int length = Math.min(s1.length(),s2.length());
    for(int i=0;i<length;i++){
        if(s1.charAt(i) == s2.charAt(i)){
          sb.append(s1.charAt(i));
        } else {
          break;
        }
    }
    return sb.toString();
  }

}
