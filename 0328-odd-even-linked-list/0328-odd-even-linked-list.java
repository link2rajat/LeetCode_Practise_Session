/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
     
        if(head==null || head.next==null || head.next.next==null )
        {
            return head;
        }
        ListNode OddHead= head;
        ListNode EvenHead= head.next;
        ListNode EvenNode = EvenHead;
        while(EvenHead !=null && EvenHead.next!=null) 
        {
        OddHead.next=EvenHead.next;
        OddHead=OddHead.next;
        EvenHead.next= OddHead.next;
        EvenHead=EvenHead.next;
 
        }
        OddHead.next= EvenNode;

        return head;
        
    }
    
 
}