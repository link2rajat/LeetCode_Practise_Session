class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
  
        
      MedianQueue window = new MedianQueue();
        double[] median = new double[nums.length - k + 1]; 
        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);
            if (i >= k) window.remove(nums[i - k]);
            if (i >= k - 1) median[i - k + 1] = window.median();
        }   
        return median;
        
    }//T-O(nlogk),S-O(k)
    
    static class MedianQueue
    {
      Queue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()), minHeap = new PriorityQueue<>();

        public void add(long n) {
            maxHeap.add(n);
            minHeap.add(maxHeap.poll());
        }   

        public double median() {
            while (maxHeap.size() - minHeap.size() >= 2) minHeap.offer(maxHeap.poll());
            while (minHeap.size() - maxHeap.size() >= 1) maxHeap.offer(minHeap.poll());
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
        }   

        public boolean remove(long n) {
            return maxHeap.remove(n) || minHeap.remove(n);
        }
    }
    
}