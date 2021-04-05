package LC206;

/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution {
    //非递归实现
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //递归实现
    public ListNode reverseListR(ListNode head) {
        if (head == null) return head;
        ListNode res =  reverseListR(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
