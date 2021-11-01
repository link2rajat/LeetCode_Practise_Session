class MyStack {
    
    Deque<Integer> newQueue;
    Deque<Integer> oldQueue ;
  int top;
    public MyStack() {
        newQueue = new ArrayDeque<>();
        oldQueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        newQueue.add(x);
        top= x;
    }
    
    public int pop() {
       while(newQueue.size()>1)
       {
           top = newQueue.poll();
           oldQueue.add(top);
       }
        int val = newQueue.poll();
        Deque<Integer> temp = newQueue;
        newQueue= oldQueue;
        oldQueue = temp;
        return val;
    }
    
    public int top() {
     
        return top;
        
    }
    
    public boolean empty() {
     return   newQueue.isEmpty(); 
    }
    

}
//Push-T-O(1),S-O(1), Pop-T-O(S),S-O(1),Top-O(1),S-O(1),Empty-O(1),S-O(1)

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */