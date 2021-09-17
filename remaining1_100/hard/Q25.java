package remaining1_100.hard;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        ListNode dummyHead = new ListNode(0,head);
        int count = 0;
        ListNode curr = head;
        ListNode preTail = dummyHead;
        while(curr != null){  
            curr = curr.next;
            count++;
            if(count == k){
                ListNode reverseHead = reverseList(head, k);
                preTail.next = reverseHead;
                preTail = head; // 因为翻转了,反转后的末尾即使原来的开头
                head = curr;
                count = 0;
            }
        }
        //处理最后不用翻转的一部分
        if(count != 0){
            preTail.next = head;
        }

        return dummyHead.next;
    }

    public ListNode reverseList(ListNode head, int k){
        ListNode pre = head;
        ListNode curr = head.next;
        head.next = null;
        int count = 1;
        while(count < k){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            count++;
        }
        return pre;
    }
}

public class Q25 {
    
}
