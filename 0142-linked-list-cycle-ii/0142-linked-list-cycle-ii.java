/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null){
            return null;
        }
        ListNode intersect = findIntersect(head);
        
        if(intersect== null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = intersect;
        
        while(slow != fast){
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow;
    }//T-O(n),S-O(1)
    
    ListNode findIntersect(ListNode head){
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast ==slow){
                return slow;
            }
        }
        
        return null;
       

        
    }
}