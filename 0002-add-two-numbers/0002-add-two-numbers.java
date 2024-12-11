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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry=0;
        while(l1 != null || l2 != null || carry != 0 ){
            
            ListNode result = new ListNode();
            int sum=0;
            sum+=(l1 !=null ? l1.val:0)+(l2 !=null ? l2.val:0)+(carry !=0 ? carry:0);
            carry = sum/10;
            head.next = new ListNode(sum%10);
            head=head.next;
            if(l1 !=null)l1=l1.next;
            if(l2 !=null)l2=l2.next;
        }
        return dummy.next;
    }
}