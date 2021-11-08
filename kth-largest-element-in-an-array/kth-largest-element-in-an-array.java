class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->n1-n2);
        
        
        for(int num:nums)
        {
            pq.add(num);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        
        return  pq.poll();
    }
    
}//T-O(nlogk),S-O(n)