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
    
    ArrayList<Integer> range = new ArrayList<>();
    
    public Solution(ListNode head) {
    
        while(head != null){
            range.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int pickIndex = (int)(Math.random()*range.size());
        return range.get(pickIndex);
    }
}//T-O(N),O(1),S-O(N)

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */