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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null){
            return head;
        }
        
        ListNode current = head, prev = null;
        
while(left>1){
    prev=current;
    current=current.next;
    left--;
    right--;
}
        ListNode con= prev,tail = current;
        
        ListNode nextNode =null;
        
        while(right>0){
            nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
            right--;
        }
        
        if(con != null){
            con.next = prev;
        }else{
            head= prev;
        }
        
tail.next=current;
        return head;
        
    }
}