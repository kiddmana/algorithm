package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2018年8月13日 上午9:11:52
 *一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手上没牌，最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组。
 */
public class BrandHeapDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int[] text = getFinalSort(20);
    for(int i=0;i<text.length;i++){
      System.out.print(text[i] + " ");
    }
  }
  
  /**
   * 先用正序的算出转换之后的位置
   * 比如{1,2,3,4}转换之后是{1,3,4,2}
   * 然后和把位置进行替换即可获得原来的位置
   * @param n
   * @return
   */
  public static int[] getFinalSort(int n){
    if(n == 0) {
      return null;
    }
    Integer[] tempfinalArr = new Integer[n];
    List<Integer> list=new ArrayList<Integer>();
    for(int i=0;i<n;i++){
      list.add((i + 1));
    }
    int count = 0;
    for(int i=0;count < tempfinalArr.length && i<list.size();){
      tempfinalArr[count] = list.get(i);
      i++;
      if(i < list.size()){
        int last = list.get(i); 
        list.add(last);
        i++;
      }
      count++;
    }
    //算出原始数据进行交换
    int[] finalArr = new int[tempfinalArr.length];
    for(int i=0;i<tempfinalArr.length;i++){
      int index = tempfinalArr[i] -1;
      finalArr[index] = i+1;
    }
    return finalArr;
  }
}
