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
    public int[] nextLargerNodes(ListNode head) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(ListNode current = head; current != null;current=current.next)
        {
            list.add(current.val);
        }
        
        int[] result = new int[list.size()];
        
        for(int index=0;index<list.size();index++)
        {
            while(!stack.isEmpty()&& list.get(stack.peek())<list.get(index))
            {
                result[stack.pop()]= list.get(index);
            }
            stack.push(index);
        }
        
        
        return result;
        
    }
}
//T-O(n),S-O(n),n->size of linkedlist