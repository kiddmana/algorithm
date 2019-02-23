package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年2月22日 下午4:20:36
      报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

  1.     1
  2.     11
  3.     21
  4.     1211
  5.     111221
  1 被读作  "one 1"  ("一个一") , 即 11。
  11 被读作 "two 1s" ("两个一"）, 即 21。
  21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
  
        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
        
        注意：整数顺序将表示为一个字符串。
        
         
        
        示例 1:
        
        输入: 1
        输出: "1"
        示例 2:
        
        输入: 4
        输出: "1211"    
 */
public class CountAndSay {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String text = countAndSay(9);
    System.out.println(text);
  }
  
  public static String countAndSay(int n) {
    String sayText = "1";
    for(int i=2;i<=n;i++){
      int count = 0;
      
      char temp = sayText.charAt(0);
      StringBuilder sb = new StringBuilder();
      for(int j=0;j<sayText.length();j++){
        if(temp == sayText.charAt(j)){
          count++; 
        } else {
          sb.append(count + "" + temp);
          temp = sayText.charAt(j);
          count = 1;
        }
        if(j == sayText.length()-1){
          temp = sayText.charAt(j);
          sb.append(count + "" + temp);
        }
      }
      sayText = sb.toString();
    }
    return sayText;
  }
  
}
