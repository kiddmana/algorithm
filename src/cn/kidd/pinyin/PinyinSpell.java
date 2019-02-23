package cn.kidd.pinyin;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 */
public class PinyinSpell {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String text = splitSpell("qinshimingyuezhijunlintianxiajinganchuang");
    System.out.println(text);
  }
  
  
  /**
   * ƴ���з�
   * @param s
   * @return
   */
  public static String splitSpell(String s) {
    String regEx = "[^aoeiuv]?h?[iuv]?(ai|ei|ao|ou|er|ang?|eng?|ong|a|o|e|i|u|ng|n)?";
    int tag = 0;
    String spell = "";
    List<String> tokenResult = new LinkedList<String>();
    for (int i = s.length(); i > 0; i = i - tag) {
      Pattern pat = Pattern.compile(regEx);
      Matcher matcher = pat.matcher(s);
      matcher.find();
      spell += (matcher.group() + " ");
      tag = matcher.end() - matcher.start();
      tokenResult.add(s.substring(0, 1));
      s = s.substring(tag);
    }

    return spell;
  }
}
