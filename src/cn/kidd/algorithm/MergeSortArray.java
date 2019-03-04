package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年3月4日 上午11:47:28
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
public class MergeSortArray {

  public static void main(String[] args) {
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    int m = 3;
    int n = 3;
    merge(nums1, m, nums2, n);
    for(int i=0;i<nums1.length;i++){
      System.out.print(nums1[i] + " ");
    }
  }
  
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1 = 0;
    int index2 = 0;
    while(index2 < n){
      for(int i=0;i<nums1.length;i++){
        if(index2 < n && nums1[i] > nums2[index2] || index1 >= m){
          addArray(nums1, i, nums2[index2]);
          index2++;
        } else {
          index1++;
        }
      }
    }
    
  }
  
  /***
   * 数据插入
   * @param nums1
   * @param index
   * @param num
   */
  public static void addArray(int[] nums1, int index, int num) {
    for(int i =nums1.length-1;i>index;i--){
      nums1[i] = nums1[i-1];
    }
    nums1[index] = num;
  }
}
