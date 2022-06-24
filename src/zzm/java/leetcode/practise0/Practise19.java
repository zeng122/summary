package zzm.java.leetcode.practise0;

public class Practise19 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode newHead = new ListNode();
      newHead.next = head;
      ListNode n1 = newHead;
      ListNode n2 = newHead;
      for(int i = 0;i<n && n2.next!=null;i++){
          n2 = n2.next;
      }
      while (n2.next != null){
          n2 = n2.next;
          n1 = n1.next;
      }
      n1.next = n1.next.next;

      return newHead.next;
    }
}
