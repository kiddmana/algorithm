package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2019年1月10日 上午10:21:31
 * 苹果分配的问题
问题描述： 
把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。 

输入 
每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。0<=n<=10<=m<=10 

1.当盘子数多于苹果数时：则必定有n-m个盘子是空着的。 
f(m,n)=f(m,m); 
2.当盘子数少于苹果数时(n<=m): 
又分两种情况： 
<1>当有空盘子时：即至少有一个盘子是空的：f(m,n)=f(m,n-1) 
<2>没有空盘子时：即所有的盘子都有苹果，从每个盘子里拿掉一个苹果对结果没有影响：f(m,n)=f(m-n.n) 
因此所有可能的情况为f(m,n)=f(m,n-1)+f(m-n.n)。 
我们知道当m=0时，只有一种放法，当n=1时只有一种放法。 
 */
public class AppleAllocation {
  public static void main(String[] args) {
    int count = getMaxCount(10, 5);
    System.out.println(count);
  }
  
  /**
   * 普通分配
   * @param m
   * @param n
   * @return
   */
  public static int getMaxCount(int m ,int n){  
    if(m==0||n==1){  
        return 1;  
    }  
    if(m<n){  
      return getMaxCount(m,m);  
    }  
    if(m>n){  
      return getMaxCount(m,n-1)+getMaxCount(m-n,n);  
    }
    return 0;
  }
}
