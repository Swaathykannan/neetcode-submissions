/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> cloneMap=new HashMap<>();
        return createClone(cloneMap,node);      
    }

    private Node createClone(Map<Node,Node> cloneMap,Node node){
        if(node==null){
            return node;
        }
        if(!cloneMap.containsKey(node)){
            cloneMap.put(node,new Node(node.val,new ArrayList()));
            for(Node neighbor:node.neighbors){
                Node cloneNode=createClone(cloneMap,neighbor);
                cloneMap.get(node).neighbors.add(cloneNode);
            }
        }
        return cloneMap.get(node);
    }
}