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
    public TreeNode invertTree(TreeNode node) {
        if(node==null){
            return null;
        }
        if(node.right!=null || node.left!=null){
            TreeNode temp=node.right;
            node.right=invertTree(node.left);
            node.left=invertTree(temp);
        }
        return node;
        
    }
}
