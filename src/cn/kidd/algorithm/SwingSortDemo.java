package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月30日 下午8:04:05
 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
nums[0] <= nums[1] >= nums[2] <= nums[3]....

 注意事项
请就地排序数组，也就是不需要额外数组
样例
给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为 [1, 6, 2, 5, 3, 4]
 */
public class SwingSortDemo {

  public static void main(String[] args) {
    int[] arr = {2,4,5,1,6,3};
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println("=======================");
    arr = putSort(arr);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println("=========================");
    int[] arr2 = {1, 4, 2, 5, 3, 6};
    arr2 = putHighSort(arr2);
    for(int i=0;i<arr2.length;i++){
      System.out.print(arr2[i] + " ");
    }
  }
  
  /**
   * 原题解法
   * @param arr
   * @return
   */
  public static int[] putSort(int[] arr){
    if(arr == null || arr.length == 0) {
      return null;
    }
    //快速排序
//    for(int i=0;i<arr.length;i++){
//      for(int j=i;j<arr.length;j++){
//        if(arr[i] > arr[j]){
//          int temp = arr[i];
//          arr[i] = arr[j];
//          arr[j] = temp;
//        }
//      }
//    }
    //如果是奇数去最大值，如果是偶数取最小值
    for(int i=0;i<arr.length;i++){
      for(int j=i;j<arr.length;j++){
        if(i%2 == 0){
          //取最大值
          if(arr[i] > arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        } else {
          //取最小值
          if(arr[i] < arr[j]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
      }
    }
    return arr;
  }
  
  /**
   * 加入变量赋值解法
   * @param arr
   * @return
   */
  public static int[] putHighSort(int[] arr){
    if(arr == null || arr.length == 0) {
      return null;
    }
    //快速排序
    for(int i=0;i<arr.length;i++){
      for(int j=i;j<arr.length;j++){
        if(arr[i] > arr[j]){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
    //开始处理加入 另外的变量可以直接赋值来处理
    int[] finalarr = new int[arr.length];
    for(int i=0,j=0;j<arr.length;i++,j = j + 2){
      finalarr[j]=arr[i];
    }
    for(int i=1,j=1;j<arr.length;i++,j = j + 2){
      finalarr[j]=arr[arr.length-i];
    }
   
    return finalarr;
  }
}
