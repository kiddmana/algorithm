package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2018年8月17日 上午11:30:34
 * 给一个由数字组成的字符串，写一个函数求出其可能恢复为的所有ip地址
 */
public class Text2IP {

  public static void main(String[] args) {
    List<String> ips = text2IP("124121153");
    for(int i=0;i<ips.size();i++){
      System.out.println(ips.get(i));
    }
  }
  
  /**
   * ip地址获取
   * @param text
   * @return
   */
  public static List<String> text2IP(String text){
    List<String> list = new ArrayList<String>();
    if(text == null || "".equals(text) ||text.length() < 4 || text.length()>12) {
      return list;
    }
    for(int i=1;i<4;i++){
      String splitText = "";
      
      splitText = Integer.parseInt(text.substring(0, i)) + ".";
      String firsttempText = splitText;
      for(int j=i+1;j<i+4 && j<text.length()+1;j++){
        splitText = splitText + Integer.parseInt(text.substring(i, j))  + ".";
        String tempText = splitText;
        for(int k =j+1;k<j+4 && k<text.length()+1;k++){
          splitText = splitText + Integer.parseInt(text.substring(j, k))  + ".";
          if(k < text.length()){
            splitText = splitText + Integer.parseInt(text.substring(k, text.length())); 
            if(!list.contains(splitText)){
              list.add(splitText);
            }
          }
          splitText = tempText;
        }
        splitText = firsttempText;
      }
      splitText = "";
    }
    List<String> finalList = new ArrayList<String>();
    for(int i=0;i<list.size();i++){
      String ip = list.get(i);
      String[] ips = ip.split("\\.");
//      System.out.println(ip + ips.length);
      if(Integer.parseInt(ips[0]) <=255 && Integer.parseInt(ips[1]) <=255 && Integer.parseInt(ips[2]) <=255 &&Integer.parseInt(ips[3]) <=255 ){
        finalList.add(ip);
      }
    }
    return finalList;
  }
  
  
}
