/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
    
    Deque<Integer> st;
    Deque<Integer> min_stack; 

    /** initialize your data structure here. */
    public MinStack() {
        st = new ArrayDeque<Integer>(); 
        min_stack = new ArrayDeque<Integer>(); 
    }
    
    public void push(int x) {
        if(min_stack.isEmpty() || x<=min_stack.peek())
        {
            min_stack.push(x);
        }
        st.push(x);
    }
    
    public void pop() {
      
        if((st.peek()).equals(min_stack.peek()))
        {
            min_stack.pop();
        }
           st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
      
      return min_stack.peek();
            
    }
}//T-O(1),S-O(n)



