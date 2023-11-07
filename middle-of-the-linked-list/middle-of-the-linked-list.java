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
    public ListNode middleNode(ListNode head) {
             ListNode fast=head;
             ListNode slow=head;
                
         int size =findLength(head);
        
        while(fast !=null && fast.next != null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    int findLength(ListNode head){
        int length=0;
        ListNode node =head;
        while(node !=null){
            length++;
            node=node.next;
        }
        return length; 
    }
}