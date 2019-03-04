package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年2月23日 下午4:55:14
 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。

直接计算会出现超时而且速度过慢
 */
public class MyPow {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    double data = myPow(2,-1);
    System.out.println(data);
  }
  
  public static double myPow(double x, int n) {
     return pow(x, n);
  }
  
  public static double pow(double x, int n) {
    if(n == 0){
        return 1.0;
    }
    if(n == 1){
      return x;
    }
    if(n == -1){
      return 1.0/x;
    }
    //递归处理
    double t = pow(x, n/2);
    if(n % 2 == 0){
      return t*t;
    } else if(n % 2 == 1){
      return t*t*x;
    }else if(n % 2 == -1){
      return t*t/x;
    }
    return 1;
  }
}
