package zzm.java.leetcode.practise0;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Practise2 {


    public static void main(String []args){
        Practise2 practise2 = new Practise2();
        practise2.init();

    }

    public void init(){

        ListNode listNode13 = new ListNode(3,null);
        ListNode listNode12 = new ListNode(4,listNode13);
        ListNode listNode11 = new ListNode(2,listNode12);

        ListNode listNode23 = new ListNode(4,null);
        ListNode listNode22 = new ListNode(6,listNode23);
        ListNode listNode21 = new ListNode(5,listNode22);

        ListNode result = addTwoNumbers(listNode11,listNode21);

        System.out.println(result);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode =  new ListNode();
        ListNode head = listNode;
        int addSum = 0;
        int sum = 0;
        while (l1 != null && l2 != null){
            sum = l1.val+l2.val+addSum;
            if(sum >= 10){
                addSum = 1;
                sum = sum % 10;
            }else{
                addSum = 0;
            }
            listNode.val = sum ;
            listNode.next = new ListNode();
            listNode = listNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            sum = l1.val+addSum;
            if(sum>=10){
                addSum = 1;
                sum = sum % 10;
            }else{
                addSum = 0;
            }
            listNode.val = sum ;
            listNode.next = new ListNode();
            listNode = listNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            sum = l2.val+addSum;
            if(sum>=10){
                addSum = 1;
                sum = sum % 10;
            }else{
                addSum = 0;
            }
            listNode.val = sum ;
            listNode.next = new ListNode();
            listNode = listNode.next;
            l2 = l2.next;
        }
        if(addSum !=0){
            listNode.val = 1;
            listNode.next = new ListNode();
        }
        ListNode listNodeTemp = head;
        while(listNodeTemp.next.next != null){
            listNodeTemp = listNodeTemp.next;
        }
        listNodeTemp.next = null;
        return head;
    }
}
