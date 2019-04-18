package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年4月17日 下午4:04:26
  国王和金矿
有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
参与挖矿工人的总数是10人。
每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
1、400金/5人   2、500金/5人   3、200金/3人    4、300金/4人    5、350金/3人
  

 */
public class MaxGoldDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] golds = {400,500,200,300,350};
    int[] persons = {5,5,3,4,3};
    int max = getMaxGold(golds, persons, 10);
    System.out.println(max);
  }
  
  /**
   * 
   * @param golds 金矿的储量
   * @param persons 挖取金矿需要人手
   * @param m 工人数量
   * @return
   */
  public static int getMaxGold(int[] golds,int[] persons,int m){
    int[] dp = new int[m+1];
    for(int i=0;i<golds.length;i++){
      for(int j = m;j>=1;j--){
        if(j>=persons[i]){
          dp[j] = Math.max(dp[j-persons[i]] + golds[i], dp[j]); 
        }
      }
    }
    return dp[m];
  }
}
