class MyQueue {
    Stack<Integer> newStack = new Stack<Integer>();
    Stack<Integer> oldStack = new Stack<Integer>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        newStack.push(x);
    }
    
    public int pop() {
       shiftStack();
       int element = oldStack.pop();
       reShiftStack();
       return element; 
    }
    
    public int peek() {
       shiftStack();
       int element = oldStack.peek();
       reShiftStack();
       return element;
    }
    
    public boolean empty() {
    return newStack.isEmpty();
    }
    
    void shiftStack(){
        
        while(!newStack.isEmpty()){
        oldStack.push(newStack.pop());
        }
    }
    void reShiftStack(){
        while(!oldStack.isEmpty()){
        newStack.push(oldStack.pop());
        }
    }
    
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */