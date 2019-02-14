package cn.kidd.algorithm;

import java.util.ArrayList;
import java.util.List;

class MyPoint{
  public int left = 0;
  public int top = 0; 
  public int right = 0;
  public  int bottom = 0;
  public int i = 0;
  public int j = 0;
  public int type = 1;
}
public class ScrewMatrixDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] matrix = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,16},
                      {17,18,19,20},
                      {21,22,23,24}};
    int[] nums = getScrewMatrix(matrix);
    for(int i=0;i<nums.length;i++){
     System.out.print(nums[i] + " "); 
    }
    System.out.println("");
    List<Integer> listnums = spiralOrder(matrix);
    for(int i=0;i<listnums.size();i++){
      System.out.print(listnums.get(i) + " "); 
     }
  }
  
  public static int[] getScrewMatrix(int[][] matrix){
    MyPoint point = new MyPoint();
    point.left = 0;
    point.top = 0;
    point.right = matrix[0].length;
    point.bottom = matrix.length;
    point.i = 0;
    point.j = 0;
    point.type = 1;
    List<Integer> list = new ArrayList<Integer>();
    
    while(point.left <= point.right && point.top <= point.bottom){
      list = sendData(point, list, matrix);
    }
    System.out.println(point.left + " " + point.right + " " + point.top + " " + point.bottom + " -- " + point.i + " " + point.j );
    //把最后一个加进来
//    if(list.get(list.size()-1) != matrix[point.i][point.j]){
//      list.add(matrix[point.i][point.j]);
//    }
//    list.add(matrix[point.i][point.j]);
    int[] nums = new int[list.size()];
    for(int k=0;k<list.size();k++){
      nums[k] = list.get(k);
    }
    return nums;
  }
  
  public static List<Integer> sendData(MyPoint point,List<Integer> list,int[][] matrix){
    if(point.left <= point.right && point.top <= point.bottom){
      switch (point.type) {
        case 1:
          //往右读取
          for(int k=point.j;k<point.right-1;k++){
            list.add(matrix[point.i][k]);
          }
          point.top++;
          point.type=2;
          point.j = point.right-1;
          return list;
        case 2:
          //往下读取
          for(int k=point.i;k<point.bottom-1;k++){
            list.add(matrix[k][point.j]);
          }
          point.right--;
          point.type=3;
          point.i = point.bottom-1;
          return list;
        case 3:
          //往左读取
//          System.out.println(" left -- " + point.left);
          for(int k=point.j;k>point.left;k--){
            list.add(matrix[point.i][k]);
          }
          point.bottom--;
          point.type=4;
          point.j = point.left;
          return list;
        case 4:
          //往上读取
//          System.out.println(" top -- " + point.top + " i " + point.i);
          for(int k=point.i;k>point.top;k--){
            list.add(matrix[k][point.j]);
          }
          point.left++;
          point.type=1;
          point.i = point.top;
          return list;
      }
    }
    return list;
  }
  
  public static List<Integer> spiralOrder(int[][] matrix){
    int n = matrix.length;
    int m = matrix[0].length;
    List<Integer> list = new ArrayList<Integer>();
    int i,j;
    //余下矩阵的行数和列数
    int p=n,q=m;
    //读取一圈元素的起始点
    int k = 0;
    while(p>0 && q>0){
      i=k;
      j=k;
      while(j<=m-k-1){
        list.add(matrix[i][j++]);
      }
      i = i + 1;
      j = n-k-1;
      while(i<=n-k-1){ 
        list.add(matrix[i++][j]);
      }
      i = n-k-1;
      j = j-1;
      while(i>k && j>=k){
        list.add(matrix[i][j--]);
      }
      i = i - 1;
      j = k;
      while(i>k && j<m-k-1){
        list.add(matrix[i--][j]);
      }
      k++;
      p -=2;
      q -=2;
    }
    return list;
  }
  
}
