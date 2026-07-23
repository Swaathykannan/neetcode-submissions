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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                s = !s.isEmpty() ? s + ",null" : s;
                continue;
            }
            s = s.isEmpty() ? String.valueOf(node.val) : s + "," + String.valueOf(node.val);
            q.add(node.left);
            q.add(node.right);
        }
        return s;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data!=null){
            String dataList[]=data.split(",");
            return deserializeToTree(dataList); 
        }
        return null;
        
    }
    private TreeNode deserializeToTree(String[] data){
        if(data[0].equals("null")){
            return new TreeNode();
        }
        int index=1;
        TreeNode node=new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode queueNode=q.peek();
            q.remove();
            for(int i=0;i<2;i++){
                if(!data[index].equals("null")){
                    if(i==0){
                        TreeNode leftNode=new TreeNode(Integer.parseInt(data[index]));
                        queueNode.left=leftNode;
                        q.add(leftNode);
                    }else{
                        TreeNode rightNode=new TreeNode(Integer.parseInt(data[index]));
                        queueNode.right=rightNode;
                        q.add(rightNode);
                    }
                }
                index++;
            }
        }
        return node;

    }
}
