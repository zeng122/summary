package zzm.java.leetcode.practise0;

public class Practise82 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Practise82 practise82 = new Practise82();
        practise82.init();
    }

    public void init(){
        ListNode listNode7 = new ListNode(5,null);
        ListNode listNode6 = new ListNode(4,listNode7);
        ListNode listNode5 = new ListNode(4,listNode6);
        ListNode listNode4 = new ListNode(3,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        deleteDuplicates(listNode1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode before = newHead;
        ListNode node = head;
        while (node!=null){
            if(node.next == null || node.val != node.next.val){
                before.next = node;
                before = node;

            }else {
                while (node.next != null && node.val == node.next.val){
                    node = node.next;
                }
            }
            node = node.next;
        }
        before.next = null;
        return  newHead.next;
    }

}
