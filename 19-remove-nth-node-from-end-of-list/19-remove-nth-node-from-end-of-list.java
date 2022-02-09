/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
     
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        int list_length=0;
        ListNode node = head;
        
        while(node != null)
        {
            node=node.next;
            list_length++;
        }
        list_length-=n;
       ListNode new_node = dummy;
        
        while(list_length>0)
        {
            list_length--;
            new_node=new_node.next;
        }
        new_node.next=new_node.next.next;
        
        return dummy.next;
        
    }
}//T-O(N),S-O(1)