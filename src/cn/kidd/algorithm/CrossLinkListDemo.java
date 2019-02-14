package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月26日 上午9:54:50
请写一个程序，找到两个单链表最开始的交叉节点。 
注意事项 
如果两个链表没有交叉，返回null。 
在返回结果后，两个链表仍须保持原有的结构。 
可假定整个链表结构中没有循环。 
样例 
下列两个链表： 
这里写图片描述 
在节点 c1 开始交叉。
链表的只和前一个节点和后一个节点有联系
 */
public class CrossLinkListDemo {

  public static void main(String[] args) {

    ListNode node1 = new ListNode();
    ListNode node2 = new ListNode();
    CrossLinkListDemo cross=new CrossLinkListDemo();
    cross.getIntersectionNode(node1, node2);
  }
  
  public ListNode getIntersectionNode(ListNode nodeA,ListNode nodeB){
    ListNode p1 = nodeA;
    ListNode p2 = nodeB;
    if(p1 == null || p2 ==null){
      return null;
    }
    //获取长度最后相等的开始比较，长度相等开始比较
    int lenA = getNodeLen(nodeA);
    int lenB = getNodeLen(nodeB);
    int dif = lenA -lenB;
    if(dif < 0) {
      return getIntersectionNode(p2, p1);
    }
    if(dif > 0) {
      p1 = p1.next;
      dif--;
    }
    //相等时开始比较
    while(p1 != null && p2 != null){
       if(p1 == p2){
         return p1;
       }
       p1 = p1.next;
       p2 = p2.next;
    }
    return null;
  }
  
  public int getNodeLen(ListNode node){
    int len = 0;
    ListNode p = node;
    while(p != null){
      len++;
      p = p.next;
    }
    return len;
  }
}
