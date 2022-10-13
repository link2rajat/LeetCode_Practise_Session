/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//From CTCL LinkedList chapter
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val=nextNode.val;
        node.next=nextNode.next;
    }
}//T-O(1),S-O(1)