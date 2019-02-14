package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author wangding 时间：2018年7月25日 下午3:51:06 
 *         给定的n和k,写一个函数，求123.n组成的排列中的第k个排列 注意事项1<=n<=9 康托展开
 *         X=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[1]*0! 逆康托展开
 */
public class KSortDemo {

  public static void main(String[] args) {
    //给一个值来判断他是排序中的第几位
    int[] num = {2, 3, 1};
    int data = getKangTuoNum(3, num);
    System.out.println(data);
    System.out.println("=========================================");
    String[] arr = getKandTuoByindex(5, 20);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }
  
  /**
   * 康托展开的逆展开：求解字典序递增的全排列中第K个排列。X=K-1，表示前面有K-1个字典序更小的排列。
   * K-1=a[n]*(n-1)!+a[n-1]*(n-2)!+...+a[i]*(i-1)!+...+a[1]*0!。
   * 可使用辗转相除法分别确定a[n]，……，a[1]。
   * 如：已知set=｛1，2，3，4｝。求第10个排列（10<4!）
   * 10/（3！）=1  余  4  a[3]=1,即当前元素是未使用元素｛1，2，3，4｝中的第一个元素（从0开始）2，则第一个元素为2
     4/（2！）  =1  余  0  a[2]=1,即当前元素是未使用元素｛1，3，4｝中的第一个元素（从0开始）3，则第二个元素为3
     0/（1！）  =0  余  1  a[1]=0,即当前元素是未使用元素｛1，4｝中第0个元素（从0开始），则第三个元素为1
     1/（0！）  =0  余  0  a[0]=0,即当前元素是未使用元素｛4｝中第0个元素（从0开始），则第四个元素为4
   * @param n
   * @param k
   * @return
   */
  public static String[] getKandTuoByindex(int n,int k){
    String[] num = new String[n];
    int maxNum = getFactorialByNum(n);
    if(maxNum < k) {
      return null;
    }
    //这个才是计算的位置
    k = k - 1;
    //开始计算
    List<String> list=new ArrayList<String>();
    for(int i=1;i<=n;i++){
      list.add(i+"");
    }
    //初始化之后赋值
    for(int i=0;i<n;i++){
      int fac = getFactorialByNum(n-i-1);
      //辗转相除法来求除数
      int data = k / fac;
      k = k % fac;
      num[i] = list.get(data);
      list.remove(data);
    }
    return num;
  }
  
  /**
   * 通过一个有序排序的数值来判断他属于第几个
   * 
   * @param n
   * @param num
   * @return
   */
  public static int getKangTuoNum(int n, int[] num) {
    int lessNum = 0;
    List<Integer> list=new ArrayList<Integer>();
    for(int i=0;i<num.length;i++){
      list.add(num[i]);
    }
    int min = Collections.min(list);
    for (int i = 0; i < n; i++) {
      int data = num[i];
      int fac = getFactorialByNum(n - i - 1);
      lessNum = lessNum + (data - min) * fac;
      list.remove(0);
      if(list.size() > 0) {
        min = Collections.min(list); 
      }
    }
    return lessNum + 1;
  }
  
  /**
   * 阶乘计算
   * @param n
   * @return
   */
  public static int getFactorialByNum(int n) {
    int sum = 1;
    for (int i = 1; i <= n; i++) {
      sum = sum * i;
    }
    return sum;
  }
}
