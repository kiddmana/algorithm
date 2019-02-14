package cn.kidd.algorithm;


/**
 * 
在一个二维01矩阵中找到全为1的最大正方形； 
样例：
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
返回 4
*
*/
public class MaxSquare {

  public static void main(String[] args) {
    int[][] matrix = {{1,0,1,0,0},
                      {1,0,1,0,1},
                      {1,1,1,1,1},
                      {1,0,1,1,1}};
    System.out.println(getMaxNum(matrix));
    System.out.println("平方值的面积： " + (getMaxNum(matrix) * getMaxNum(matrix)));
  }
  
  public static int getMaxNum(int[][] matrix){
    int row = matrix.length;
    if(row == 0) {
      return 0;
    }
    int col =matrix[0].length;
    if(col == 0){
      return 0;
    }
    int[][] sum =new int[row][col];
    int max = 0;
    for(int i=0;i<row;i++){
      if(sum[i][0] == 1) {
        sum[i][0] = 1;
        max = 1;
      }
    }
    for(int j=0;j<col;j++){
      if(sum[0][j] == 1) {
        sum[0][j] = 1;
        max = 1;
      }
    }
    for(int i=1;i<row;i++){
      for(int j=1;j<col;j++){
        if(matrix[i][j] == 1) {
          //判断最大的正方形
            int n = Math.min(sum[i-1][j-1], sum[i-1][j]);
            n = Math.min(n, sum[i][j-1]);
            sum[i][j] = n+1;
            max = Math.max(max, sum[i][j]);
        }
      }
    }
    return max;
  }
  
}
