package Tree.MorrisTraverse;
import java.util.ArrayList;
import java.util.List;

public class InOrderTraverse {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Morris Inorder Traversal (without stack and recursion)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param root root of the tree
     * @return inorder traversal of the tree
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        TreeNode cur = root;
        if (cur == null) return lst;
        while (cur != null) {
            // If left child is null, then visit this node and go to right child.
            if (cur.left == null) {
                lst.add(cur.val);
                cur = cur.right;
            } else {
                // Find the predecessor of current node.
                TreeNode pre = findPre(cur);
                // If predecessor's right child is same as current node, then visit this node
                // and go to right child.
                if (pre.right == cur) {
                    lst.add(cur.val);
                    cur = cur.right;
                    // If predecessor's right child is not same as current node,
                    // establish the link and go to left child.
                } else {
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }
        return lst;
    }

    /**
     * Find the predecessor of current node.
     * @param x current node
     * @return predecessor of current node
     */
    public TreeNode findPre(TreeNode x) {
        TreeNode node = x.left;
        while (node.right != null && node.right != x) {
            node = node.right;
        }
        return node;
    }
}