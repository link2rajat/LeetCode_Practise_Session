class Solution {
    public int findKthLargest(int[] nums, int k) {
        
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int element:nums){
            pq.offer(element);
        }
        
         while(pq.size()>k){
                pq.poll();
            }
        return pq.peek();
        
    }
}