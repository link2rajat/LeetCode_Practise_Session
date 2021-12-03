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
        
        List<Integer> list = new ArrayList<>();
        
        for(ListNode current=head;current != null;current=current.next)
        {
            list.add(current.val);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[] result = new int[list.size()];
  
        for(int i=0;i<list.size();i++)
        {
           while(!stack.isEmpty() && list.get(stack.peek())<list.get(i))
           {
               result[stack.pop()]=list.get(i);
           }
            stack.push(i);
        }
        return result;
        
    }
}//T-O(n),S-O(n)