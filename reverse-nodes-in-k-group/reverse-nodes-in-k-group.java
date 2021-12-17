/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    
        ListNode ptr = head;
        
        int count=0;
        
        while(count<k && ptr!=null)
        {
            ptr=ptr.next;
            count+=1;
        }
        
        if(count==k)
        {
            ListNode revHead = reverseKNodes(head,k);
            head.next=reverseKGroup(ptr,k);
            return revHead;
        }
        return head;
    }
    
    ListNode reverseKNodes(ListNode head, int k)
    {
        ListNode prev=null;
        
        
        while(k>0)
        {
            ListNode nextHead = head.next;
            head.next = prev;
            prev=head;
            head = nextHead;
            k--;
        }
        return prev;
    }
}//T-O(N),S-O(N/k)