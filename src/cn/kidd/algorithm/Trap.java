package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年2月23日 上午11:05:26
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 */
public class Trap {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    int water = trap(height);
    System.out.println(water);
  }
  
  /**
   * 对比左右两边的最高值，往中间移动算出多的差距值
   * @param height
   * @return
   */
  public static int trap(int[] height) {
    int water = 0;
    int maxLeft = 0;
    int maxRight = 0;
    int left = 0;
    int right = height.length -1;
    while(left < right){
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);
      //判断大小
      if(maxLeft > maxRight){
        //左边的大于右边
        water = water + (maxRight - height[right--]);
      } else {
        water = water + (maxLeft - height[left++]);
      }
    }
    
    return water;
  }
}
