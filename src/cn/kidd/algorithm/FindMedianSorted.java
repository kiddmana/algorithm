package cn.kidd.algorithm;

/**
 * 
 * @author wangding 时间：2019年2月14日 下午4:43:55 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 *         请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 *         你可以假设 nums1 和 nums2 不会同时为空。
 * 
 *         示例 1:
 * 
 *         nums1 = [1, 3] nums2 = [2]
 * 
 *         则中位数是 2.0 示例 2:
 * 
 *         nums1 = [1, 2] nums2 = [3, 4]
 * 
 *         则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSorted {

  public static void main(String[] args) {
    int[] num1 = {1,5};
    int[] num2 = {3}; 
    double mid = findMedianSortedArrays(num1, num2);
    System.out.println(mid);
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //获取最小长短的数组
    int m = nums1.length;
    int n = nums2.length;
    if(m>n){
      int[] temps = nums1;
      nums1 = nums2;
      nums2 = temps;
      int temp = m;
      m = n;
      n = temp;
    }
    int imin = 0;
    int imax = m;
    int halflen = (n + m +1)/2;
    //i + j = halflen
    while(imin <= imax){
      int i = (imin + imax) / 2;
      int j = halflen - i;
      //划分之后的数值对比
      if(i<imax && nums2[j-1] > nums1[i]){
        //短的数组索引增加
        imin = imin + 1;
      } else if(i > imin && nums1[i-1] > nums2[j]){
        //短的数组索引减小
        imax = imax - 1;
      } else {
        //满足条件
        int maxLeft = 0;
        if(i == 0){
          //判断极端条件的处理
          maxLeft = nums2[j-1]; 
        } else if(j == 0){
          maxLeft = nums1[i-1]; 
        } else {
          maxLeft = Math.max(nums1[i-1], nums2[j-1]);
        }
        //奇数个数的数组
        if((n + m) % 2 == 1){
          return maxLeft;
        }
        
        //右边最小值
        int minRight = 0;
        if(i == m){
          minRight = nums2[j];
        } else if(j == n){
          minRight = nums1[i];
        } else {
          minRight = Math.min(nums1[i], nums2[j]);
        }
        double midResult = (maxLeft + minRight) / 2.0;
        return midResult;
      }
    }
    return 0.0;
  }
  
}
