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
    private int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        checkheight(root);
        return diameter;
    }
    private int checkheight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftheight=checkheight(node.left);
        int rightheight=checkheight(node.right);
        diameter=Math.max(diameter,leftheight+rightheight);
        return 1+Math.max(leftheight,rightheight);
        
    }
}
