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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
        
        for(ListNode listTogetfirstNode: lists)
        {    
            if(listTogetfirstNode !=null)
            pq.add(listTogetfirstNode);
        }
        
        ListNode resultHead=null;
        ListNode resultTail=null;
        while(!pq.isEmpty())
        {
        ListNode node = pq.poll();
        if(resultHead==null)
        {
            resultHead=resultTail=node;
        }
        else
        {
            resultTail.next=node;
            resultTail=resultTail.next;
        }
      
        if(node.next !=null)
            {
            pq.add(node.next);        
            }        
        }
        
        
        return resultHead;
    }
}//T-O(nlogk),S-O(n)