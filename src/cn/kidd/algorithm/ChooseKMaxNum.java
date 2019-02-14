package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年9月4日 下午5:44:46
 * 给定一个数组，取出第k大的数
 */
public class ChooseKMaxNum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] arr = {2,9,5,12,32,18};
    int num = getKNum(arr, 4);
    System.out.println("num = " + num);
  }
  
  public static int getKNum(int[] arr,int k){
    if(arr == null || arr.length == 0 || k < 1){
      return 0;
    }
    if(k > arr.length){
      return 0;
    }
    //开始快速排序
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        
        if(arr[i] < arr[j]){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
//    for(int i=0;i<arr.length;i++){
//      System.out.print(arr[i] + " ");
//    }
    return arr[k-1];
  }
}
