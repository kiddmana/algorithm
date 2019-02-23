package cn.kidd.algorithm;

public class NumSum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums={2, 7, 11, 15};
    int target = 9;
    int[] result = twoSum(nums, target);
    System.out.println(result[0] + " -- " + result[1]);
  }
  
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for(int i=0;i<nums.length;i++){
        for(int j=i + 1;j<nums.length;j++){
            int data = nums[i] + nums[j];
            if( data == target){
                result[0] = i;
                result[1] = j;
            }
        }
    }
    return result;
  }
}
