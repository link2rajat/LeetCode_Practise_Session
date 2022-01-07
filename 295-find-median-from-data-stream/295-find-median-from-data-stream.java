class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int elemcount;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {

            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
   
        if(minHeap.size()>maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
        {
            return (double)((minHeap.peek())+(maxHeap.peek()))*(0.5);
        }
        return (double)maxHeap.peek();
    }
}//T-O(logn),S-O(n)

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */