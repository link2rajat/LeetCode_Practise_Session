/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       
        if(lists==null || lists.length==0)return null;
        return mergelist(0,lists.length-1,lists);
    } 
    
    static ListNode mergelist (int start, int end,ListNode[] lists)
    {
        
        if(start>=end)
            return lists[start];
        int mid = start+(end-start)/2;
        ListNode leftList = mergelist(start,mid,lists); 
        ListNode rightList = mergelist(mid+1,end,lists); 
              return merge(leftList,rightList);
     
    }
    
    static ListNode merge(ListNode l,ListNode r)
    {
        if(l==null)
            return r;
        if(r==null)
            return l;
        if(l.val<r.val)
        {
         l.next= merge(l.next,r);
            return l;
        }
           r.next= merge(l,r.next);
            return r;
    }

    
}//T-O(nlogk),S-O(1) where k lis the number of lists and n is the total number of nodes in two lists