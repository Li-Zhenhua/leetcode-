package 每日一题;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        int dst = count - k + 1;
        count = 1;
        while(count < dst){
            head = head.next;
            count++;
        }
        return head;
    }
}

public class _9_2_剑指Q22 {
    
}
