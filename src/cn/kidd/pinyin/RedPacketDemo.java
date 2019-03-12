package cn.kidd.pinyin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author wangding
 * 时间：2019年3月7日 下午4:30:57
 * 微信红包功能
 */
public class RedPacketDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Double> list = getRedPacketValue(5.5, 7.5, 20);
    for(int i=0;i<list.size();i++){
      System.out.print(list.get(i) + " ");
    }
    
    double data = BigDecimal.valueOf(127 * (31/100.0)).setScale(1, RoundingMode.HALF_UP).doubleValue();
    System.out.println(data);
  }
  
  public static List<Double> getRedPacketValue(double minValue,double maxValue,int n){
    List<Double> values = new ArrayList<Double>();
    double dif = maxValue - minValue;
    Random random = new Random();
    BigDecimal bigDecimal = BigDecimal.valueOf(dif * 10 + 1);
    int round = bigDecimal.intValue();
    for(int i=0;i<n;i++){
      double value = minValue + random.nextInt(round)/10.0; 
      values.add(value);
    }
    return values;
  }
}
