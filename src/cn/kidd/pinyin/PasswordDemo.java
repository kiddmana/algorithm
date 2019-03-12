package cn.kidd.pinyin;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


/**
 * 
 * @author wangding
 * 时间：2019年3月7日 下午4:33:10
 * 哈希撒盐加密算法
 */
public class PasswordDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
//      System.out.println(PasswordHash.createHash("123456"));
      String password = "1000:53384d720d51a37b76485fbe81964d83800c2b7e6dfc0fcb:e2a248d6668209202e1d3141accfa911034bcc2670dd6bb8";
      boolean flag = PasswordHash.validatePassword("123456", password);
      System.out.println(flag);
      String passwordText = PasswordHash.createHash("123456");
      System.out.println(passwordText);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
