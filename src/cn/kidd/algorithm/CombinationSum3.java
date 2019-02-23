package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年2月22日 下午1:33:42
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {
  static List<List<Integer>> list = new ArrayList<List<Integer>>();
  public static void main(String[] args) {
    int[] candidates = {1,2,3,4,5,6,7,8,9};
    int target = 9;
    int count = 3;
    Sort(candidates);
    List<List<Integer>> listdata = combinationSum2(candidates, target,count);
    for(int i=0;i<listdata.size();i++){
      System.out.println(listdata.get(i));
    }
  }
  
  public static List<List<Integer>> combinationSum2(int[] candidates, int target,int count) {
    List<Integer> temp = new ArrayList<Integer>();
    combinationFindSum(list, temp, candidates, target, 0,count);
    return list;
  }
  
  public static void combinationFindSum(List<List<Integer>> allList,List<Integer> temp,int[] candidates, int target,int num,int count) {
    //如果相等则是结果
    if(target == 0){
      //进行去重处理数据
      if(temp.size() == count){
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
      combinationFindSum(allList, tempData, candidates, target - candidates[i] , i + 1,count);
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
