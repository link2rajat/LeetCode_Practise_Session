/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
         
         ListNode fast=head;
         ListNode slow=head;
        
        while(fast.next!=null && fast.next.next != null)
            {
            slow = slow.next;
            fast=fast.next.next;
            }
        
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        slow = reverseLL(slow);
        
        fast=head;
        
        while(slow!=null)
        {
            
            if(slow.val!=fast.val)
            {
                return false;
            }
            slow = slow.next;
            fast=fast.next;
        }
        return true;
        
    }
    
    ListNode reverseLL(ListNode head)
    {
        
        ListNode prev = null;
        
        while(head !=null)
        {
            ListNode nxtPtr = head.next;
            head.next=prev;
            prev=head;
            head=nxtPtr;
        }
       return prev; 
    }
}//T-O(n),S-O(1)