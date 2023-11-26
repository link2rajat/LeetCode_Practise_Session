class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int element:nums){
            pq.offer(element);
             if(pq.size()>k){
                pq.poll();
            }
        }
        
        
        return pq.peek();
        
    }
}