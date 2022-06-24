package zzm.java.leetcode.practise100;

import zzm.java.leetcode.practise0.Practise92;

import java.util.ArrayList;
import java.util.List;

public class Practise143 {
   public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
       Practise143 practise143 = new Practise143();
       practise143.init();
    }
    public void init(){
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        reorderList(listNode1);
    }
    public void reorderList(ListNode head) {

        //1
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n2 != null && n2.next!= null){
            n1 = n1.next;
            n2 = n2.next.next;
        }

        //2
        ListNode head2 = new ListNode();
        head2.next = null;
        n2 = n1.next;
        n1.next = null;
        while (n2 != null){
            ListNode next = n2.next;
            n2.next = head2.next;
            head2.next = n2;
            n2 = next;
        }

        //3
        n1 = head;
        n2 = head2.next;
        while (n1!= null && n2!= null){
            ListNode next1  =  n1.next;
            ListNode next2  =  n2.next;
            n1.next = n2;
            n2.next = next1;
            n1 = next1;
            n2 = next2;
        }

    }

}
