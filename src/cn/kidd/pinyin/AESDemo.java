package cn.kidd.pinyin;

/**
 * 
 * @author wangding
 * ʱ�䣺2019��4��15�� ����5:15:20
 * AES�����㷨
 */
public class AESDemo {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    String data = "{'data':'���ǵ�һ��AES����'}";
    String key = "kiddwongstudy666";
    String aesData = AESUtil.encrypt(data, key);
    System.out.println("aesData = " + aesData);
    String oldData = AESUtil.decrypt(aesData, key);
    System.out.println("oldData = " + oldData);
  }

}
