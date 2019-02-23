package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年2月22日 下午1:33:42
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
public class CombinationSum {
  static List<List<Integer>> list = new ArrayList<List<Integer>>();
  public static void main(String[] args) {
    int[] candidates = {6,7,2,3};
    int target = 7;
    Sort(candidates);
    List<List<Integer>> listdata = combinationSum2(candidates, target);
    for(int i=0;i<listdata.size();i++){
      System.out.println(listdata.get(i));
    }
  }
  
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<Integer> temp = new ArrayList<Integer>();
    combinationFindSum(list, temp, candidates, target, 0);
    return list;
  }
  
  public static void combinationFindSum(List<List<Integer>> allList,List<Integer> temp,int[] candidates, int target,int num) {
    //如果相等则是结果
    if(target == 0){
      allList.add(temp);
    }
    if(target < candidates[0]){
      return;
    }
    //递归处理数据
    for(int i= num;i<candidates.length;i++){
      List<Integer> tempData = new ArrayList<Integer>(temp);
      //从下面的开始计算数据
      tempData.add(candidates[i]);
      combinationFindSum(allList, tempData, candidates, target - candidates[i] , i);
    }
  }
  
  public static void Sort(int[] candidates){
    for(int i=0;i<candidates.length;i++){
      for(int j= i+1;j<candidates.length;j++){
        if(candidates[i] > candidates[j]){
          int temp = candidates[i];
          candidates[i] = candidates[j];
          candidates[j] = temp;
        }
      }
    }
  }
}
