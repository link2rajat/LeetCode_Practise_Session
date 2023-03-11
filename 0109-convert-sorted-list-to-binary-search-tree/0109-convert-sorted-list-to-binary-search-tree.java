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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode mid = findMiddelElement(head);
        
        TreeNode node = new TreeNode(mid.val);
        
        if(head==mid){
            return node;
        }
        
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(mid.next);
        
      return node;  
    }//T-O(NlogN),S-O(log n)
    
    ListNode findMiddelElement(ListNode head){
        ListNode prevPtr = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next != null){
           prevPtr = slow;
           slow =slow.next;
           fast =fast.next.next;
        }
        
        if(prevPtr !=null){
           prevPtr.next=null; 
        }
        
        return slow;
    }
}