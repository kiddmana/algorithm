package cn.kidd.algorithm;

/***
 * 
 * @author wangding
 * 时间：2018年7月23日 下午5:31:37
给一个二维的矩阵，包含 ‘X’ 和 ‘O’, 找到所有被 ‘X’ 围绕的区域，并用 ‘X’ 填充满。
样例 
给出的二维矩阵： 
X X X X 
X O O X 
X X O X 
X O X X

把被 ‘X’ 围绕的区域填充之后变为： 
X X X X 
X X X X 
X X X X 
X O X X
 */
public class AroundRegion {

  public static void main(String[] args) {
    
    String[][] matrix = {{"X", "X", "X", "X" },
                         {"X", "O", "O", "X" },
                         {"X", "X", "O", "X"},
                         {"X", "O", "X", "O"},
                         {"X", "O", "O", "X"},
                         {"X", "X", "O", "X" }};
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++){
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("========================================");
    matrix = getNewRegion(matrix);
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++){
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("");
    }
  }
  
  public static String[][] getNewRegion(String[][] matrix){
    int row = matrix.length;
    if(row <= 1) {
      return matrix;
    }
    int col = matrix[0].length;
    if(col <= 1){
      return matrix;
    }
    //列赋值
    for(int i=0;i<row;i++){
      if("O".equals(matrix[i][0])){
        regionGoing(matrix, i, 0);
      }
      if("O".equals(matrix[i][col-1])){
        regionGoing(matrix, i, col-1);;
      }
    }
    //行赋值
    for(int j=0;j<col;j++){
      if("O".equals(matrix[0][j])){
        regionGoing(matrix, 0, j);
      }
      if("O".equals(matrix[row-1][j])){
        regionGoing(matrix, row-1, j);
      }
    }
    //循环深度搜索处理
    
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        if("O".equals(matrix[i][j])){
          matrix[i][j] = "X";
        }
        if("*".equals(matrix[i][j])){
          matrix[i][j] = "O";
        }
      }
    }
    return matrix;
  }
  
  /**
   * 深度递归算法处理
   * @param matrix
   * @param i
   * @param j
   */
  public static void regionGoing(String[][] matrix,int i,int j){
    int row = matrix.length;
    int col = matrix[0].length;
    if(i>=row || j>=col || i<=0 || j<=0){
      return;
    }
    if(!"O".equals(matrix[i][j])){
      return;
    }
    matrix[i][j] = "*";
    regionGoing(matrix, i, j-1);
    regionGoing(matrix, i, j+1);
    regionGoing(matrix, i-1, j);
    regionGoing(matrix, i+1, j);
  }
}
