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
    public boolean isValidBST(TreeNode root) {
        return validateBinarySearchTree(root,-1001,1001);
    }
    private boolean validateBinarySearchTree(TreeNode root,int min,int max){
        if (root == null) {
            return true;
        }
        boolean leftResult = false;
        boolean rightResult = false;
        if (root.val<=min||root.val>=max) {
            return false;
        }
        leftResult = validateBinarySearchTree(root.left,min,root.val);
        rightResult = validateBinarySearchTree(root.right,root.val,max);
        return leftResult && rightResult;
    }
}
