package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年2月22日 下午1:33:42
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSum2 {
  static List<List<Integer>> list = new ArrayList<List<Integer>>();
  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};
    int target = 8;
    Sort(candidates);
//    List<List<Integer>> listdata = combinationSum2(candidates, target);
    System.out.println(System.currentTimeMillis());
    List<List<Integer>> listdata = combinationSumNew(candidates, target);
    System.out.println(System.currentTimeMillis());
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
      //进行去重处理数据
      if(!allList.contains(temp)){
        allList.add(temp); 
      }
    }
    if(target < candidates[0]){
      return;
    }
    //递归处理数据
    for(int i= num;i<candidates.length;i++){
      List<Integer> tempData = new ArrayList<Integer>(temp);
      //从下面的开始计算数据
      tempData.add(candidates[i]);
      //数据去重处理
      combinationFindSum(allList, tempData, candidates, target - candidates[i] , i + 1);
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
  
  //另外一种递归的方式
  public static void combinationFindSumNew(List<List<Integer>> allList,List<Integer> temp,int[] candidates, int target,int num) {
  //如果相等则是结果
    if(target == 0){
      allList.add(temp); 
    }
    if(target < candidates[0]){
      return;
    }
    //深度拷贝处理
    for(int i=num;i<candidates.length && candidates[i] <= target;i++){
      List<Integer> tempData = new ArrayList<Integer>(temp);
      //从下面的开始计算数据
      tempData.add(candidates[i]);
      combinationFindSumNew(allList, tempData, candidates, target - candidates[i] , i + 1);
      //判断重复的数据
      int q = i;
      while(q+1 < candidates.length && candidates[i] == candidates[q+1]){
         q++;
      }
      if(q>i){
         i = q + 1;
         if(q== candidates.length -1){
           break;
         }
      }
    }
  }
  
  public static List<List<Integer>> combinationSumNew(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<Integer>();
    combinationFindSumNew(list, temp, candidates, target, 0);
    return list;
  }
}
