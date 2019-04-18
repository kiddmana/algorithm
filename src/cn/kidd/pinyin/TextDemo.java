package cn.kidd.pinyin;

public class TextDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String text = Integer.toBinaryString(2);
    System.out.println(text);
    System.out.println(Long.toBinaryString(30));
    System.out.println(String.format("%04d", Integer.parseInt(text)));
  }

}
