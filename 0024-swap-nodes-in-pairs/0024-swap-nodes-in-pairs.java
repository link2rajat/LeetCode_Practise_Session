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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        
        dummy.next = head;
        
        ListNode previousNode = dummy;
        
        while((head != null) && (head.next !=null)){
                        //1
            ListNode firstNode = head;
                          //2              
            ListNode secondNode = head.next;
            
            //swapNode
                    //dummy-->2
            previousNode.next = secondNode;
                    //1-->3
            firstNode.next = secondNode.next;
                       //2-->1
            secondNode.next = firstNode;
                    //prev->1
            previousNode = firstNode;
                    //head->3
            head = firstNode.next;
        }
        
        return dummy.next;
    }
}//T-O(N),S-O(1)