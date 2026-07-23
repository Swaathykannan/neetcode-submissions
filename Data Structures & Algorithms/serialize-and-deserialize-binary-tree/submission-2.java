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
     int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serializeTreeToString(root,s);
        return s.toString();
        
    }

    private void serializeTreeToString(TreeNode node,StringBuilder s){
        if(node==null){
            s=s.length()==0?s.append("null"):s.append(",null");
            return;
        }
        s=s.length()==0?s.append(node.val):s.append(","+node.val);
        serializeTreeToString(node.left,s);
        serializeTreeToString(node.right,s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String dataList[]=data.split(",");
        return deserializeToTree(dataList);     
    }
    private TreeNode deserializeToTree(String[] data){
        if(data[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(data[index]));
        index++;
        node.left=deserializeToTree(data);
        node.right=deserializeToTree(data);
        return node;
    }
}
