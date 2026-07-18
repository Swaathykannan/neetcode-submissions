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
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node){
        int maxDepth=0;
        if(node==null){
            return maxDepth;
        }
        maxDepth++;
        maxDepth=Math.max(maxDepth+dfs(node.right),maxDepth+dfs(node.left));
        return maxDepth;
    }
}
