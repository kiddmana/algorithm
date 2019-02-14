package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SortSolution {
  public static void main(String[] args) {
    List<String> res = Permutation("ABCDEFHI");
    System.out.println(res.size());
    for(int i=0;i<res.size();i++){
//      System.out.println(res.get(i));
    }
  }
  
  public static List<String> Permutation(String str) {
    List<String> res = new ArrayList<String>();
    if(str == null || str.length() <= 0)
        return res;
    HashSet<String> set = new HashSet<String>(); //结果去重
    dfs(set, str.toCharArray(), 0);
    res.addAll(set);
    Collections.sort(res);
    return res;
  }
  
  public static void dfs(HashSet<String> set, char [] str, int k){
      if(k == str.length){  //得到结果
          set.add(new String(str));
          return ;
      }
      for(int i = 0; i < str.length; i ++){
          swap(i, k, str);
          dfs(set, str, k + 1);
          swap(i, k, str);  //回溯
      }
  }
  
  public static void swap(int i, int j, char [] str){
      if(i != j){
          char temp = str[i];
          str[i] = str[j];
          str[j] = temp; 
      }
  }
}
