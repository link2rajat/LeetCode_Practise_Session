/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        
        ListNode current = dummy;
        
        int carry=0;
        
        while(l1 !=null || l2 != null || carry !=0)
        {
          int val1 = ((l1 ==null) ? 0:l1.val);            
          int  val2=((l2 ==null) ? 0:l2.val);
         
          int sum=  val1+val2+carry;           
            
          int val=(sum)%10;
           
            
            ListNode newNode = new ListNode(val);
            
            current.next=newNode;
            current= newNode;

            carry= sum/10;

            if(l1 !=null) l1=l1.next;
            if(l2 !=null) l2=l2.next;
            
        }
        
        return dummy.next;
        
    }
}//T-O(max(m,n)),S-O(max(m,n)) where m is length of l1 and n is length of l2