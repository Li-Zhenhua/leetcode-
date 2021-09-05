package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //中序遍历延伸，反着中序，即右中左
 //然后前缀和形式的感觉,每次记录遍历到的所有元素之和
/*class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}*/

//常数空间的Morris遍历法
/*
1、如果左子节点是空，录入当前节点，当前指针cur指向右子节点
2、如果左子节点不是空，遍历左子节点的最右侧右子节点，找到最右侧叶节点，在寻找的过程中可能出现两种情况：
    -如果遍历到的叶节点的右子节点是空，把叶节点的右子节点指向cur节点，cur移向左子节点
    -如果遍历到的叶节点的右子节点是cur节点，表示原来的叶节点到cur节点连接已经存在，现在遍历结束了，需要复原，置节点的右子节点为空，在录入了cur节点之后，cur移到自己的右子节点
3、重复上面两步直到当前节点为空

*/
//然后反向遍历思想
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}





public class Q538 {
    
}
