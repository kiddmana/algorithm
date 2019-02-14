package cn.kidd.algorithm;

/***
 * 
 * @author wangding
 * 时间：2018年7月24日 下午3:23:15
 给定一个包含红，白，蓝且长度为 n 的数组，写一个函数实现将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。我们可以使用整数 0，1 和 2 分别代表红，白，蓝。

注意事项： 
1、不能使用代码库中的排序函数来解决这个问题。 
2、排序需要在原数组中进行。

格式：

第一行输入一个由 0，1，2 组成的数组，最后输出分类排序后的数组。

样例输入

[ 1，0，1，2 ]

样例输出

[ 0，1，1，2 ]
 */
public class ColorTypeDemo {
  public static void main(String[] args) {
    int[] arr= {0,2,1,2,2,0,1,1,0,2};
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
    //使用选择排序,不用中间量
    for(int i=0;i<arr.length;i++){
//      int temp = arr[i];
      for(int j=i+1;j<arr.length;j++){
       if(arr[i] > arr[j]){
//         temp = arr[j];
         arr[j] = arr[j]^arr[i];
         arr[i] = arr[j]^arr[i];
         arr[j] = arr[j]^arr[i];
       }
      }
    }
    System.out.println("");
    System.out.println("=============================");
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }
  
  
}
