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
    public ListNode rotateRight(ListNode head, int k) {
    
        if(head==null) return null;

        if(head.next==null) return head;

        ListNode  oldhead = head;
       int size;
        for(size=1;oldhead.next != null;size++)
        {
          oldhead = oldhead.next;
        }
        oldhead.next =head;

        
         ListNode  newtail = head;
    
        for(int i= 0;i<size-k%size-1;i++)
        {
            newtail=newtail.next;
        }
          ListNode newhead = newtail.next;
        
        newtail.next = null;
        
        
        return newhead;
    }
}//T-O(N),S-O(1)