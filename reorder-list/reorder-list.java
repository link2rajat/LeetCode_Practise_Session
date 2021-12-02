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
    public void reorderList(ListNode head) {
      
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow=reverseLL(slow);
       
        fast = head;
      
        ListNode temp = head;
        
        while(slow.next!=null)
        {
            temp = fast.next;
            fast.next = slow;
            fast = temp;
            
            temp = slow.next;
            slow.next = fast;
            slow = temp;
            
        }
        
    }//T-O(n),S-O(1)
    
    
    ListNode reverseLL(ListNode head)
    {
        ListNode prev = null;
        while(head!=null)
        {
           ListNode nextHead = head.next;
            head.next=prev;
            prev=head;
            head=nextHead;
        }
        return prev;
    }
}