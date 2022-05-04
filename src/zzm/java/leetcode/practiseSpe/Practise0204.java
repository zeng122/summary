package zzm.java.leetcode.practiseSpe;


/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 分割链表
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * [1,4,3,2,5,2]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practise0204 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static  void main(String []args){

        Practise0204 practise0204 = new Practise0204();

        practise0204.init();

    }

    public void init(){
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(2);
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(5);
//        listNode4.next = listNode5;
//        ListNode listNode6 = new ListNode(2);
//        listNode5.next = listNode6;
        partition(listNode1,3);
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        boolean needChange = false;
        ListNode index = head;
        if(head.val>=x){
            needChange = true;
            index = null;
        }

        ListNode node =head;
        while (node != null && node.next != null){
            if(node.next.val<x){
                if(needChange){
                    ListNode temp = node.next;
                    node.next = temp.next;
                    //需要插头
                    if(index == null){
                        temp.next = head;
                        head  =  temp;
                    }else{
                        temp.next = index.next;
                        index.next = temp;
                    }
                    index = temp;
                }else{
                    index = node.next;
                    node = node.next;
                }
            }else if(node.next.val>=x){
                needChange = true;
                node = node.next;
            }


        }
        return head;
    }
}
