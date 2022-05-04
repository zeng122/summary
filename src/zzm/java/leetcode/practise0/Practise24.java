package zzm.java.leetcode.practise0;
public class Practise24 {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Practise24 practise24 = new Practise24();
    }


    public ListNode swapPairs(ListNode head) {

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode ln = newHead;
        ListNode temp;
        while (ln.next != null && ln.next.next!=null){
            temp = ln.next;
            ln.next = ln.next.next;
            temp.next = ln.next.next;
            ln.next.next = temp;
            ln = ln.next.next;
        }

        return newHead.next;


    }
}
