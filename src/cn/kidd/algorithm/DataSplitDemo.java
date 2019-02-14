package cn.kidd.algorithm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年1月19日 下午1:57:21
 * 一个集合拆分所有子集
 */
public class DataSplitDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Integer> list = new ArrayList<Integer>();
    list.add(200);
    list.add(400);
    list.add(250);
    list.add(350);
    list.add(200);
    list.add(260);
    list.add(200);
    list.add(500);
    list.add(400);
    list.add(300);
    List<String> data = getAllData(list);
    for(int i=0;i<data.size();i++){
      System.out.println(data.get(i));
    }
  }
  
  
  public static List<String> getAllSonData(List<String> list,int length){
    List<String> data = new ArrayList<String>();
    if(list != null && list.size() > 0){
      
    }
    return data;
  }
  
  public static String getNumTextData(int length){
    String data = new String();
    for(int i=1;i<=length;i++){
      data = i+",";
    }
    data = data.substring(0, data.length() -1);
    return data;
  }
  
  public static List<String> getAllData(List<Integer> list){
    List<String> data = new ArrayList<String>();
    int dataCount = (int) Math.pow(2, list.size())-1;
    for(int i=1;i<=dataCount;i++){
      data.add(binaryToDecimal(i,list.size()));
    }
    return getFinalData(data);
  }
  
  public static List<String> getFinalData(List<String> data){
    List<String> allData = new ArrayList<String>();
    if(data!= null && data.size() > 0){
     int length =  data.get(0).length();
     for(int i=0;i<data.size();i++){
       String text = num2Text(data.get(i), length);
       allData.add(text);
     }
    }
    return allData;
  }
  
  public static String num2Text(String text,int length){
    String finalText = "{";
    for(int i=0;i<length;i++){
      String t = text.substring(i, i+1);
      if("1".equals(t)){
          finalText = finalText + (i+1) + ",";
      }
    }
    finalText = finalText.substring(0, finalText.length() -1) + "}";
    return finalText;
  }
  
  /**
   * ʮ����ת������
   * @param n
   */
  public static String binaryToDecimal(int n,int size){
    String str = "";
    while(n!=0){
        str = n%2+str;
        n = n/2;
    }
    String zoreType = "";
    for(int i=0;i<size;i++){
      zoreType = zoreType + "0";
    }
    DecimalFormat g1=new DecimalFormat(zoreType);
    String startZeroStr = g1.format(Integer.valueOf(str));
    return startZeroStr;
  }
}
