package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月31日 下午7:14:46
 * 给你一个二维矩阵，权值为False和True,False为0,True为1，写一个函数找到一个最大的矩形，使得里面的只全部为True,并输出他面积
 */
public class MaxRectangleDemo {

  public static void main(String[] args) {
    int[][] matrix = {{1,1,1,0,0},
                      {1,0,1,0,1},
                      {1,1,1,1,1},
                      {1,0,1,1,1}};
    
    int maxSum = getMaxArea(matrix);
    System.out.println(maxSum);
  }
  
  public static int getMaxArea(int[][] matrix){
    int row = matrix.length;
    if(row == 0 ){
      return 0;
    }
    int col = matrix[0].length;
    if(col == 0){
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int[][] sum = new int[row][col];
    for(int i=0;i<row;i++){
      if(matrix[i][0] == 1){
        sum[i][0] = 1;
        if(i != 0) {
          sum[i][0] = sum[i-1][0] + 1;
        }
        max = Math.max(max, sum[i][0]);
      }
    }
    for(int j=0;j<col;j++){
      if(matrix[0][j] == 1){
        sum[0][j] = 1;
        if(j != 0) {
          sum[0][j] = sum[0][j-1] + 1;
        }
        max = Math.max(max, sum[0][j]);
      }
    }
    System.out.println(max);
    for(int i=1;i<row;i++){
      for(int j=1;j<col;j++){
         if(matrix[i][j] == 1){
           if((sum[i-1][j-1] == 0) && (sum[i][j-1] == 0) && (sum[i-1][j] == 0)) {
             sum[i][j] = 1;
           } else {
             if((sum[i][j-1] == 0) && (sum[i-1][j] > 0)){
               if(i == 1) {
                 sum[i][j] = matrix[i-1][j] + 1;
               } else {
                 sum[i][j] = sum[i-1][j] + 1; 
               }
             }else if((sum[i][j-1] > 0) && (sum[i-1][j] == 0)){
               if(j == 1){
                 sum[i][j] = matrix[i][j-1] + 1;
               } else {
                 sum[i][j] = sum[i][j-1] + 1; 
               }
             }else if((sum[i][j-1] > 0) && (sum[i-1][j] > 0) && (sum[i-1][j-1] == 0)){
//               System.out.println("sum[i][j-1] = " + sum[i][j-1] + " sum[i-1][j]=  " + sum[i-1][j]);
               sum[i][j] = Math.max(sum[i][j-1], sum[i-1][j]) + 1;
             }else if((sum[i][j-1] > 0) && (sum[i-1][j] > 0) && (sum[i-1][j-1] > 0)){
               sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + 1;
             }
           }
           max = Math.max(max, sum[i][j]);
           System.out.println(" i ="+ (i + 1)+ " j = " + (j+1) + " max = " + max  + "  sum[i][j] =" + sum[i][j]);
         }
      }
    }
    return max;
  }
}
