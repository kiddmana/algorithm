package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding 时间：2019年2月19日 下午4:26:52 题意：给定1~n n个正整数，写出它们的所有排列顺序。
 * 
 *         思路：根据高中的知识，我们知道不重复的条件下结果是n!个排列顺序，在程序中我们先看看如何用递归来实现。
 * 
 *         例如数组｛1，2，3｝的全排列为123，132，213，231 ,312 ,321。
 */
public class PermutationDemo {

  static List<List<Integer>> list = new ArrayList<List<Integer>>();

  public static void main(String[] args) {

    int[] arr = {1, 2,3};
    permutate(arr, 0);
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println("");
    System.out.println("--------------------------------------------------");
    List<List<Integer>> list2 = permutate2(arr);
    for (int i = 0; i < list2.size(); i++) {
      System.out.print(list2.get(i) + " ");
    }
  }
  
  /**
   * 通过递归方式来进行替换数据
   * @param data
   * @param begin
   */
  public static void permutate(int[] data, int begin) {
    int length = data.length;
    if (begin == length) {
      list.add(arr2List(data));
    }

    for (int i = begin; i < length; i++) {
      if(isUnique(data, begin, i)){
        //换过去替换
        swap(data, begin, i);
        permutate(data, begin + 1);
        //换回来，给下一次进行替换
        swap(data, begin, i); 
      }
    }
  }

  private static void swap(int[] data, int left, int right) {
    int temp = data[left];
    data[left] = data[right];
    data[right] = temp;
  }
  
  private static boolean isUnique(int[] data, int left, int right) {
    //左边到要替换的右边有没有数据重复，如果有则不需要替换
    for(int i=left;i<right;i++){
      if(data[i] == data[right]){
        return false;
      }
    }
    return true;
  }

  public static List<Integer> arr2List(int[] data) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < data.length; i++) {
      list.add(data[i]);
    }
    return list;
  }
  
  /**
   * 换一种方式的递归,不重复的情况下的数据
   * @param nums
   * @return
   */
  public static List<List<Integer>>  permutate2(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> l1 = new ArrayList<Integer>();
    l1.add(nums[0]);
    result.add(l1);
    for(int i = 1;i<nums.length;i++){
       List<List<Integer>> resultx = new ArrayList<List<Integer>>();
       for(List<Integer> list:result){
           for(int j =0;j<=list.size();j++ ){
              List<Integer> list2 = new ArrayList<Integer>();
              list2.addAll(list);
              list2.add(j,nums[i]) ;              
               resultx.add(list2);
           }   
         }
        result = resultx;
       }
    return result;
  }
}
