package cn.kidd.pinyin;

/**
 * 
 * @author wangding
 * 时间：2019年4月15日 下午5:15:20
 * AES加密算法
 */
public class AESDemo {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    String data = "{'data':'我是第一个AES加密'}";
    String key = "kiddwongstudy666";
    String aesData = AESUtil.encrypt(data, key);
    System.out.println("aesData = " + aesData);
    String oldData = AESUtil.decrypt(aesData, key);
    System.out.println("oldData = " + oldData);
  }

}
