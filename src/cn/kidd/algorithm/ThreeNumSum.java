package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * 
 * @author wangding 时间：2019年4月4日 下午5:02:36 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b +
 *         c = 0 ？找出所有满足条件且不重复的三元组。
 * 
 *         注意：答案中不可以包含重复的三元组。
 * 
 *         例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 *         满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeNumSum {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println("start time = " + System.currentTimeMillis());
    List<List<Integer>> allList = threeSum(nums);
    for (List<Integer> list : allList) {
      System.out.println(list);
    }
    System.out.println("end time = " + System.currentTimeMillis());
  }

  /**
   * 暴力解法测试 时间很长
   * 
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> allList = new ArrayList<List<Integer>>();
    List<String> keyList = new ArrayList<String>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int num = nums[i] + nums[j] + nums[k];
          if (num == 0) {
            TreeSet<Integer> treeSet = new TreeSet<Integer>();
            treeSet.add(nums[i]);
            treeSet.add(nums[j]);
            treeSet.add(nums[k]);
            Iterator<Integer> iterator = treeSet.iterator();
            String key = "";
            while (iterator.hasNext()) {
              key = key + iterator.next() + ":";
            }
            if (!keyList.contains(key)) {
              List<Integer> list = new ArrayList<Integer>();
              list.add(nums[i]);
              list.add(nums[j]);
              list.add(nums[k]);
              allList.add(list);
              keyList.add(key);
            }
          }
        }
      }
    }
    return allList;
  }


  /**
   * 暴力解法测试 时间很长
   * 
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSumNew(int[] nums) {
    List<List<Integer>> allList = new ArrayList<List<Integer>>();
    // 先排序在计算数据
    Arrays.sort(nums);
    int index1 = 0;
    int index2 = 1;
    while (index1 < nums.length - 2) {
      int target = nums[index1];
      if (target > 0) {
        // 退出循环
        break;
      }
      int curVar = nums[index2];
      // 去重处理
      if ((index2 - index1) > 1 && nums[index2 - 1] == curVar) {
        index2++;
        if (index2 == nums.length) {
          index1++;
          index2 = index1 + 1;
        }
        continue;
      }
      int diff = 0 - (curVar + target);
      int left = index2, right = nums.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] == diff && mid != index1 && mid != index2) {
          List<Integer> ls = new ArrayList<>();
          ls.add(nums[index1]);
          ls.add(nums[index2]);
          ls.add(nums[mid]);
          Collections.sort(ls);
          allList.add(ls);
          break;
        } else if (nums[mid] > diff) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      index2++;
      if (index2 == nums.length) {
        index1++;
        index2 = index1 + 1;
      }
    }
    return allList;
  }
}
