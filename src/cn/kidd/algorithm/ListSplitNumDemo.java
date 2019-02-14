package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年1月19日 上午9:25:11
 * 集合划分操作
题目：n个元素的集合{1,2,.,n }可以划分为若干个非空子集。

例如，当n=4 时，集合{1,2,3,4}可以划分为15个不同的非空子集如下： 
{1}，{2}，{3}，{4}}， {{1，2}，{3}，{4}}， 
{{1，3}，{2}，{4}}， {{1，4}，{2}，{3}}， 
{{2，3}，{1}，{4}}， {{2，4}，{1}，{3}}， 
{{3，4}，{1}，{2}}， {{1，2}，{3，4}}， 
{{1，3}，{2，4}}， {{1，4}，{2，3}}， 
{{1，2，3}，{4}}， {{1，2，4}，{3}}， 
{{1，3，4}，{2}}， {{2，3，4}，{1}}， 
{{1，2，3，4}}

求解划分的个数
 */
public class ListSplitNumDemo {
  public static void main(String[] args) {
    int count =0;
    int n=16;
    for(int i=1;i<=n;i++){
      count = count + getPartitionNum(n, i);
    }
    System.out.println("集合数量为"+ n + "可划分的子集组成等于全集的划法有 " + count);
  }
  
  /**
   * 划分的个数
   * @param n 总数量
   * @param m 划分的子集个数
   * @return
   */
  public static int getPartitionNum(int n,int m){
    if(n<m){
      return 0;
    }
    if(n==1 || m==1 || n==m){
      return 1;
    }else{
      return getPartitionNum(n-1, m-1) + m*getPartitionNum(n-1, m);
    }
  }
}
