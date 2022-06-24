package zzm.java.leetcode.practise0;

public class Practise92 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Practise92 practise92 = new Practise92();
        practise92.init();
    }

    public void init(){
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode3 = new ListNode(3,listNode5);

        reverseBetween(listNode3,1,1);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 0;
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode tempTail = null;
        ListNode tempBeforeHead = null;
        ListNode tempHead = null;
        ListNode temp = newHead;
        while (temp != null){
            ListNode nextNode = temp.next;;
            if(index == left-1) {
                tempBeforeHead = temp;
            }
            if(index == left){
                tempTail = temp;
                tempHead = temp;
            }
            if(index == right){
                temp.next = tempHead;
                tempHead = temp;
                tempTail.next = nextNode;
                tempBeforeHead.next = tempHead;
                break;
            }
            if(index>left && index < right){
                temp.next = tempHead;
                tempHead = temp;
            }
            temp = nextNode;
            index++;
        }
        return newHead.next;
    }
}
