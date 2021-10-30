/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
    
    ListNode prev = null;
        
        while(head != null)
        {
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
       }
        return prev;
    }
    
 }//T-O(n),S-O(1), n is length of Linked List