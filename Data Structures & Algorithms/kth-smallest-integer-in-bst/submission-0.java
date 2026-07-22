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
    int order=0;
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root,k);
    }
    private int findKthSmallest(TreeNode node,int k){
        if(node==null){
            return -1;
        }
        int left=findKthSmallest(node.left,k); 
        if(left!=-1){
            return left;    
        }
        order++;
        if(order==k){
            return node.val;
        }
        int right=findKthSmallest(node.right,k);
        if(right!=-1){
            return right;
        }    
        return -1;
    }
}
