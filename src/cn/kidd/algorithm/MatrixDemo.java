package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author wangding
 * 时间：2018年7月6日 上午11:54:48
 * 矩阵消消乐 找出二维矩阵中是一的块数，左边右边是1，上面下面是1为一块
 * 
 * 1 0 0 0 1
 * 0 0 1 1 0
 * 1 0 1 0 0
 * 1 1 0 1 0
 * 0 1 0 1 1
 * 
 * 上面例子有5块
 */
public class MatrixDemo {
	public static void main(String[] args) {
		int[] num = new int[]{1,0,1,0,0,
							  1,0,1,0,1,
							  0,0,1,0,1, 
							  1,0,1,1,1};
		getSameCount(num,5,4);
	}
	
	private static int getSameCount(int[] num,int col,int row){
		Map<Integer,ArrayList<Integer>> map=new LinkedHashMap<Integer,ArrayList<Integer>>();
		int count = 1;
		for(int i=0;i<num.length;i++){
			if(num[i] == 1){
				if(map.keySet().size() == 0) {
					ArrayList<Integer> datalist = new ArrayList<Integer>();
					datalist.add(i);
					map.put(count, datalist);
					count++;
				} else {
					boolean flag = false;
					for(Integer in : map.keySet()){
						ArrayList<Integer> list = map.get(in);
						List<Integer> roundList = getScrollIndex(i, 5, 4);
						boolean tempFlag = false;
						for(int j=0;j<list.size();j++){
							if(roundList.contains(list.get(j))) {
								flag = true;
								tempFlag = true;
							}
						}
						if(tempFlag) {
							list.add(i);
							map.put(in, list);
						}
					}
					if(!flag){
						ArrayList<Integer> datalist = new ArrayList<Integer>();
						datalist.add(i);
						map.put(count, datalist);
						count++;
					}
				}
			}
		}
		List<ArrayList<Integer>> tempfinalList = new ArrayList<ArrayList<Integer>>();
		//交集处理
		for(Integer in : map.keySet()){
			ArrayList<Integer> list = map.get(in);
			for(int i=0;i<list.size();i++){
				System.out.println("key = " + in + " value = " + list.get(i));
			}
			tempfinalList.add(list);
		}
		List<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i < tempfinalList.size();i++){
			if(finalList.size() == 0) {
				finalList.add(tempfinalList.get(i));
			} else {
				boolean flag = true;
				int num1 = -1;
				int num2 = -1;
				for(int j=0;j<finalList.size();j++){
					if(Collections.disjoint(finalList.get(j), tempfinalList.get(i))){
						//没有交集
						flag = true;
					} else {
						flag = false;
						num1 = i;
						num2 = j;
					}
				}
				if(flag) {
					System.out.println("添加数据i=" + i);
					finalList.add(tempfinalList.get(i));	
				} else {
					System.out.println("====有交集==== i = " + num1 + "    ===j=" + num2);
					ArrayList<Integer> list = list2Add(finalList.get(num2), tempfinalList.get(num1));
					finalList.get(num2).clear();
					finalList.get(num2).addAll(list);
				}
			}
		}
		System.out.println("=======================最终结果========================");
		for(int i=0;i<finalList.size();i++){
			for(int j=0;j<finalList.get(i).size();j++){
				System.out.println("key = " + i + " value = " + finalList.get(i).get(j));
			}
		}
		return 0;
	}
	
	private static List<Integer> getScrollIndex(int num,int col,int row){
		List<Integer> indexs = new ArrayList<Integer>();
		int i = num / col;
		int j = num - i * col;
		int max = col * row -1;
		int left = i*col + j - 1;
		int right = i*col + j + 1;
		int top = (i-1) * col + j;
		int bottom = (i+1) * col + j;
		if(left<=max && left >=0 && j > 0) {
			indexs.add(left);
		}
		if(right<=max && right >=0 && j < (col-1)) {
			indexs.add(right);
		}
		if(top<=max && top >=0 && i > 0) {
			indexs.add(top);
		}
		if(bottom<=max && bottom >=0 && i<(row-1)) {
			indexs.add(bottom);
		}
		return indexs;
	}
	
	private static ArrayList<Integer> list2Add(ArrayList<Integer> list1,ArrayList<Integer> list2){
		ArrayList<Integer> finalList = new ArrayList<Integer>();
		finalList.addAll(list1);
		for(int i=0;i<list2.size();i++){
			if(!finalList.contains(list2.get(i))){
				finalList.add(list2.get(i));
			}
		}
		return finalList;
	}
}
