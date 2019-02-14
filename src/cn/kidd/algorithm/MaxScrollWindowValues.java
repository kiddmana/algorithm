package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年8月28日 下午1:38:42
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 */
public class MaxScrollWindowValues {

  public static void main(String[] args) {
    int[] nums = {2,3,4,2,6,2,5,1};
    for(int i=0;i<nums.length;i++){
      System.out.print(nums[i] + " ");
    }
    System.out.println("");
    System.out.println("===========================================");
    int[] maxNums = getMaxWindowValues(nums, 4);
    for(int i=0;i<maxNums.length;i++){
      System.out.print(maxNums[i] + " ");
    }
  }
  
  public static int[] getMaxWindowValues(int[] nums,int n){
    if(nums == null || n > nums.length){
      return null;
    }
    int[] maxNum = new int[nums.length - n + 1];
    for(int i=0;i<nums.length - n + 1;i++){
      int maxresult = Integer.MIN_VALUE;
      for(int j=i;j<i+n;j++){
        maxresult = Math.max(maxresult, nums[j]);
      }
      maxNum[i] = maxresult;
    }
    return maxNum;
  }
}
