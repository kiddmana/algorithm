package cn.kidd.algorithm;

/**
 * 
 * @author wangding
 * 时间：2018年7月26日 上午10:46:54
 * 自定义链表实体类
 */
public class ListNode {
  /**下一个节点*/
  public ListNode next;
  /**上一个节点*/
  public ListNode before;
  
  public ListNode() {
  }

  public ListNode(ListNode next, ListNode before) {
    this.next = next;
    this.before = before;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public ListNode getBefore() {
    return before;
  }

  public void setBefore(ListNode before) {
    this.before = before;
  }
}
