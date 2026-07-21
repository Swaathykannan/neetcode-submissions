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
class TreeLevel{
    int level;
    TreeNode node;
    TreeLevel(int level,TreeNode node){
        this.level=level;
        this.node=node;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeLevel> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList();
        q.add(new TreeLevel(1,root));
        while(!q.isEmpty()){
            TreeNode node=q.peek().node;
            int level=q.peek().level;
            q.remove();
            if(node!=null){
                if(list==null ||list.isEmpty()|| list.size()<level){
                    list.add(new ArrayList());
                    list.get(level-1).add(node.val);
                }else{
                    list.get(level-1).add(node.val);
                }
                
                q.add(new TreeLevel(level+1,node.left));
                q.add(new TreeLevel(level+1,node.right));
            }    
        }
        return list;
    }
}
