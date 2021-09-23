package 每日一题;

import org.w3c.dom.Node;

/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        flattenReturnTail(head);
        return head;
    }

    public Node flattenReturnTail(Node head){
        //if(head.next == null) return head;
        Node curr = head;
        while(curr.next != null){
            if(curr.child != null){
                Node temp = curr.next;
                curr.next = curr.child;
                curr.next.prev = curr;
                Node tail = flattenReturnTail(curr.child);
                //注意要将child置空，置空的位置也得在用完之后
                curr.child = null;
                tail.next = temp;
                temp.prev = tail;
                curr = temp;
            }else{
                curr = curr.next;
            }
        }
        //最后一个节点有child时
        if(curr.child != null){
            curr.next = curr.child;
            curr.next.prev = curr;
            Node tail = flattenReturnTail(curr.child);
            curr.child = null;
            return tail;
        }
        return curr;
    }
}

public class _9_24_Q430 {
    
}
