class MovingAverage {
    
    Deque<Integer> queue = new ArrayDeque<>();
    int size;
    double sum=0;
    int count=0;
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        count++;
        
        int tail=count>size? queue.poll():0;
        sum+=val-tail;
        queue.offer(val);
        
        return sum/Math.min(count,size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */