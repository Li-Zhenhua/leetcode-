package 每日一题;

/**
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

返回一个符合上述规则的链表的列表。

举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

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

 //就正常先遍历一遍找总长，然后取平均与余数，余数的个数就是前面n个元素要多1
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        ListNode[] ans = new ListNode[k];
        while(curr != null){
            len++;
            curr = curr.next;
        }
        curr = head;
        if(len < k){
            for(int i = 0; i < len; i++){
                ans[i] = curr;
                curr = curr.next;
                ans[i].next = null;
            }
            return ans;
        }
        int avg = len / k;
        int remainder = len % k;
        for(int i = 0; i < remainder; i++){
            ans[i] = curr;
            for(int j = 0; j < avg; j++){
                curr = curr.next;
            }
            //最后一个元素
            ListNode temp = curr;
            curr = curr.next;
            temp.next = null;
        }
        for(int i = remainder; i < k; i++){
            ans[i] = curr;
            for(int j = 0; j < avg-1; j++){
                curr = curr.next;
            }
            //最后一个元素
            ListNode temp = curr;
            curr = curr.next;
            temp.next = null;
        }
        return ans;
    }
}

public class _9_22_Q725 {
    
}
