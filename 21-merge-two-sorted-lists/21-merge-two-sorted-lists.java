/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        while(l1!=null && l2 != null)
        {
            if(l1.val<=l2.val)
            {
                prev.next=l1;
                l1=l1.next;
            }
            else 
            {
                prev.next=l2;
                l2=l2.next;
            }
            prev= prev.next;
        }
        
        prev.next = l1==null ? l2:l1;
        return result.next;
    }
}//T-O(m+n),S-O(1) where m is length of l1 list and n is length of l2 list