package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author wangding
 * 时间：2019年1月19日 上午9:25:11
 * 集合划分操作
题目：n个元素的集合{1,2,.,n }可以划分为若干个非空子集。

例如，当n=4 时，集合{1,2,3,4}可以划分为15个不同的非空子集如下： 
{1}，{2}，{3}，{4}}， {{1，2}，{3}，{4}}， 
{{1，3}，{2}，{4}}， {{1，4}，{2}，{3}}， 
{{2，3}，{1}，{4}}， {{2，4}，{1}，{3}}， 
{{3，4}，{1}，{2}}， {{1，2}，{3，4}}， 
{{1，3}，{2，4}}， {{1，4}，{2，3}}， 
{{1，2，3}，{4}}， {{1，2，4}，{3}}， 
{{1，3，4}，{2}}， {{2，3，4}，{1}}， 
{{1，2，3，4}}

所有的情况显示出来
 */
public class ListSplitDemo {

  public static void main(String[] args) {
    List<String> inputSet = new ArrayList<String>();
    inputSet.add(1+"");
    inputSet.add(2+"");
    inputSet.add(3+"");
    inputSet.add(4+"");
    inputSet.add(5+"");
    inputSet.add(6+"");
    inputSet.add(7+"");
    inputSet.add(8+"");
    inputSet.add(9+"");
    List<List<List<String>>> list = partitions(inputSet);
    for(List<List<String>> l:list){
      System.out.println(l);
    }
    System.out.println("total = " + list.size());
  }
  
  /**
   * 
   * @param n 总的数量
   * @param m 划分的集合个数
   * @return
   */
  private static List<List<List<String>>> partitions(List<String> inputSet) {
    List<List<List<String>>> res = new ArrayList<>();
    if (inputSet.isEmpty()) {
        List<List<String>> empty = new ArrayList<>();
        res.add(empty);
        return res;
    }
    int limit = 1 << (inputSet.size() - 1);
    for (int j = 0; j < limit; ++j) {
        List<List<String>> parts = new ArrayList<>();
        List<String> part1 = new ArrayList<>();
        List<String> part2 = new ArrayList<>();
        parts.add(part1);
        parts.add(part2);
        int i = j;
        for (String item : inputSet) {
            parts.get(i&1).add(item);
            i >>= 1;
        }
        for (List<List<String>> b : partitions(part2)) {
            List<List<String>> holder = new ArrayList<>();
            holder.add(part1);
            holder.addAll(b);
            res.add(holder);
        }
    }
    return res;
  }
}
