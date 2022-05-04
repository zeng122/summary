package zzm.java.leetcode.practise100;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 */
public class Practise142 {

    public static void main(String []args){
        Practise142 practise142 = new Practise142();
        practise142.init();

    }

    public void init(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        detectCycle(listNode1);
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * a位环形节点开始
     * 相遇时 f1 = a+n1b , f2 = a+n2b
     * f1 = 2f2  2a+2n1b = a+n1b
     * f1 = f2+n3b
     * f2 = n3b ,即f2走的路程一定是n3b
     * n3b+a一定在a点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        if(slow == null || slow.next == null){
            return null;
        }
        boolean haveCicle = false;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            if(slow == fast){
                haveCicle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if(!haveCicle){
            return null;
        }
        //都走一步
        slow = slow.next;
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
