package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年8月29日 下午4:39:03
 给定一个m×n矩阵，如果一个元素是0，则将其所在行和列全部元素变成0
 样例
给出一个矩阵[[1,2],[0,3]]，返回[[0,2],[0,0]]
要求在原矩阵基础上处理
 
 */
public class Matrix2Zero {
  public static void main(String[] args) {
    String[][] matrix = {{"2","3","4","0"},
                         {"1","2","3","4"},
                         {"7","0","5","7"},
                         {"2","6","3","9"},
                         {"1","8","5","4"}};
    matrix = getZeroMatrix(matrix);
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++){
        System.out.print(matrix[i][j] + "   ");
      }
      System.out.println("");
      System.out.println("");
    }
  }
  
  public static String[][] getZeroMatrix(String[][] matrix){
    int m = matrix.length;
    if(matrix == null || m == 0){
      return null;
    }
    int n = matrix[0].length;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if("0".equals(matrix[i][j])){
          matrix[i][j] = "#";
        }
      }
    }
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if("#".equals(matrix[i][j])){
          matrix = setZeroMatrix(matrix, i, j);
        }
      }
    }
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if("#".equals(matrix[i][j])){
          matrix[i][j] = "0";
        }
      }
    }
    return matrix;
  }
  
  /**
   * 行列赋值
   * @param matrix
   * @param i
   * @param j
   * @return
   */
  public static String[][] setZeroMatrix(String[][] matrix,int i,int j){
    int m = matrix.length;
    int n = matrix[0].length;
    //行比较
    for(int k=0;k<m;k++){
      if(!"#".equals(matrix[k][j])){
        matrix[k][j] = "0";
      }
    }
    //列比较
    for(int k=0;k<n;k++){
      if(!"#".equals(matrix[i][k])){
        matrix[i][k] = "0";
      }
    }
    return matrix;
  }
}
