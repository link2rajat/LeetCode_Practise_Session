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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0 || lists==null)return null;
        return mergeList(0,lists.length-1,lists);
        
    }
    
    ListNode mergeList(int start,int end,ListNode[] lists)
    {
        if(start>=end)
            return lists[start];
        int mid = start+(end-start)/2;
        ListNode l1 = mergeList(start,mid, lists);
        ListNode l2 = mergeList(mid+1,end,lists);
      return  merge(l1,l2);

    }
    
    ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1== null)
            return l2;
       if(l2== null)
            return l1;
        if(l1.val< l2.val)
        {
            l1.next=merge(l1.next,l2);
            return l1;
        }
            l2.next=merge(l1,l2.next);
            return l2;
    }
}//T-O(nlogk),S-O(1)