/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node:lists){
            if(node!=null){
                minheap.add(node);
            }    
        }  
        ListNode result=new ListNode();
        ListNode tail= result;
        while(!minheap.isEmpty()){
            ListNode node=minheap.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null){
                minheap.add(node.next);
            }
        }
        return result.next;
    }
}
