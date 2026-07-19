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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLowestCommonAncestor(root, p, q);
    }
    private TreeNode findLowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node.val == p.val || node.val == q.val)
            return node;
        TreeNode rightNode = findLowestCommonAncestor(node.right, p, q);
        TreeNode leftNode = findLowestCommonAncestor(node.left, p, q);
        if (rightNode != null && leftNode != null) {
            return node;
        } else if (rightNode!=null){
            return rightNode;
        }
        return leftNode;
    }
}

