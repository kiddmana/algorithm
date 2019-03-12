package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年3月4日 下午6:25:46
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class ListSubSet {

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> list = subsets(nums);
    for(int i=0;i<list.size();i++){
      System.out.println(list.get(i));
    }
  }
  
  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> allList=new ArrayList<List<Integer>>();
    int totalCount = 1<<nums.length; 
    for(int i=0;i<totalCount;i++){
      String text = Integer.toBinaryString(i);
      text = String.format("%0" + nums.length + "d", Integer.parseInt(text));
      List<Integer> list = new ArrayList<Integer>();
      for(int j=0;j<text.length();j++){
        if(text.charAt(j) == '1'){
          list.add(nums[j]);
        }
      }
      allList.add(list);
    }
    return allList;
  }

}
