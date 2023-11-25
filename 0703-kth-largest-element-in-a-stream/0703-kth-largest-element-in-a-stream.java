class KthLargest {
    
    int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
  
    public KthLargest(int k, int[] nums) {
        
        this.k=k;
        for(int num:nums){
            queue.offer(num);
        }
        
          while(queue.size()>k){
           queue.poll();
        }
        
    }
    
    public int add(int val) {
      
        queue.offer(val);
        if(queue.size()>k){
           queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */