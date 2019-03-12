package cn.kidd.pinyin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author wangding
 * 抽奖功能
 */
public class AliasDemo {
	private double[] probability;
	private int[] alias;
	private int length;
	private Random random;
	
	public AliasDemo(List<Double> prob) {
		this(prob, new Random());
	}
	
	/**
	 * 初始化数据
	 * @param prob
	 * @param rand
	 * 
	 */
	public AliasDemo(List<Double> prob, Random rand) {
		if(prob == null || rand == null){
			throw new NullPointerException();
		}
		if(prob.size() == 0) 
			throw new IllegalArgumentException("参数错误");
		this.probability = new double[prob.size()];
		this.alias = new int[prob.size()];
		this.length = prob.size();
		this.random=rand;
		double[] tempprob = new double[prob.size()];
		
		Deque<Integer> large = new ArrayDeque<Integer>();
		Deque<Integer> small = new ArrayDeque<Integer>();
		for(int i=0;i<length;i++){
			tempprob[i] = prob.get(i)*length;
			if(tempprob[i] < 1) {
				small.add(i);
			} else {
				large.add(i);
			}
		}
		
		//进行平摊出栈
		while(!small.isEmpty() && !large.isEmpty()){
			Integer less = small.pop();
			Integer more = large.pop();
			
			probability[less] = tempprob[less];
			alias[less] = more;
			//平摊之后大的数值
			tempprob[more] = tempprob[more] - (1.0 - probability[less]);
			
			if(tempprob[more] < 1.0) {
				small.add(more);
			} else {
				large.add(more);
			}
		}
		
		while(!small.isEmpty()) {
			probability[small.pop()] = 1.0;
		}
		
		while(!large.isEmpty()) {
			probability[large.pop()] = 1.0;
		}
	}
	
	public int next(){
		int index = random.nextInt(length);
		boolean flag = random.nextDouble() < probability[index];
		return flag ? index : alias[index];
	}
	
	/**
	 * 概率测试
	 * @param args
	 */
	public static void main(String[] args) {
		List<Double> prob=new ArrayList<Double>();
		prob.add(0.15);
		prob.add(0.25);
		prob.add(0.25);
		prob.add(0.2);
		prob.add(0.15);
		int[] cnt = new int[prob.size()];  
        AliasDemo am = new AliasDemo(prob); 
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        map.put("1", 2);
        map.put("2", 5);
        map.put("3", 10);
        map.put("4", 20);
        map.put("5", 25);
        
        allHasPrize(am, map);
	}
	
	/**
	 * 奖品全部抽完
	 * @param am
	 * @param map
	 */
	private static void allHasPrize(AliasDemo am, Map<String, Integer> map) {
		List<String> data=new ArrayList<String>();
        Map<String,List<String>> dataList = new LinkedHashMap<String,List<String>>();
        for(int i=0;i<35;i++){
        	data.add("数据" + (i+1));
        }
        boolean flag = true;
        for(int i=0;i<4;i++) {
        	if(dataList.get("" + (i+1))== null || map.get((i+1) + "") != dataList.get("" + (i+1)).size()){
        		flag = true;
        	}
        }
        int count = 0;
        int gocount = 0;
        while(flag && count < data.size()){
        	int index = am.next();
        	gocount++;
        	List<String> list = dataList.get("" + (index+1));
        	if(list != null) {
        		if(map.get((index+1) + "") ==null || map.get((index+1) + "") > dataList.get("" + (index+1)).size()) {
        			list.add(data.get(count));
            		dataList.put("" + (index+1), list);
        			count++;
        		}
        	} else {
        		list = new ArrayList<String>();
        		list.add(data.get(count));
        		dataList.put("" + (index+1), list);
        		count++;
        	}
        	flag = false;
        	//判断数据
        	for(int i=0;i<4;i++) {
            	if(dataList.get("" + (i+1))== null || map.get((i+1) + "") != dataList.get("" + (i+1)).size()){
            		flag = true;
            	}
            } 
        }
        
        System.out.println("运行总次数"+ gocount);
        System.out.println("======================" + count);
		for(Map.Entry<String, List<String>> entry : dataList.entrySet()){
			System.out.println(entry.getKey() + "====================总数量 " + entry.getValue().size());
			for(int i=0;i<entry.getValue().size();i++){
				System.out.println(" key= "  + entry.getKey() + " ==  value= " + entry.getValue().get(i));
			}
		}
	}

}
