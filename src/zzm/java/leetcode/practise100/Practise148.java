package zzm.java.leetcode.practise100;

import java.util.ArrayList;
import java.util.List;

public class Practise148 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }


   public void init(){
       ListNode listNode5 = new ListNode(0,null);
       ListNode listNode4 = new ListNode(4,listNode5);
       ListNode listNode3 = new ListNode(3,listNode4);
       ListNode listNode2 = new ListNode(5,listNode3);
       ListNode listNode1 = new ListNode(-1,listNode2);
       sortList(listNode1);
   }
    public static void main(String[] args) {
      Integer a =102;
      List<Integer> list = new ArrayList<>();
      list.add(a);
      a = 102 ;
      Practise148 practise148 = new Practise148();
      practise148.init();
    }



    //将两个链表合并，并返回头节点和尾节点
    public ListNode[] merge(ListNode head1,ListNode head2){
      ListNode newHead = new ListNode();
      ListNode newTail = null;
      ListNode before = newHead;
      ListNode node1 = head1;
      ListNode node2 = head2;
      while (node1 !=null && node2!=null) {
          if(node1.val<=node2.val) {
              before.next = node1;
              before = node1;
              node1 = node1.next;
          }else{
              before.next = node2;
              before = node2;
              node2 = node2.next;
          }
      }
      while (node1 !=null){
          before.next = node1;
          before = node1;
          newTail = node1;
          node1 = node1.next;
      }
      while (node2!=null){
          before.next = node2;
          before = node2;
          newTail = node2;
          node2 = node2.next;
      }
      ListNode[] result = new ListNode[2];
      result[0] = newHead.next;
      result[1] = newTail;
      return result;
    }

    public ListNode sortList(ListNode head) {
      if(head == null || head.next == null){
          return head;
      }

      int length = 0;
      ListNode node = head;
      while (node != null){
          length++;
          node = node.next;
      }
      ListNode newHead = new ListNode();
      newHead.next = head;
      for(int subLen = 1;subLen<length;subLen = subLen<<1){
          ListNode indexHead = newHead.next;
          ListNode indexBefore = newHead;
          while (indexHead != null){
              ListNode head1 = indexHead;
              ListNode tail1 = head1;
              for(int i = 1;i<subLen && tail1!=null && tail1.next!=null ;i++) {
                  tail1 = tail1.next;
              }

              ListNode head2 = tail1.next;
              ListNode tail2 = head2;
              for(int i = 1;i<subLen && tail2!=null && tail2.next!=null;i++) {
                  tail2 = tail2.next;
              }
              //拆分
              if(tail2 == null){
                  indexHead = null;
              }else{
                  indexHead = tail2.next;
                  tail2.next = null;
              }
              tail1.next = null;


              //合并
              ListNode[] merge = merge(head1,head2);
              indexBefore.next = merge[0];
              indexBefore = merge[1];
          }
      }
      return newHead.next;
  }




}
