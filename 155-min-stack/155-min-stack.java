/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
    
   Deque<Integer> stack;
   Deque<Integer> minStack;
    
    public MinStack()
    {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    } 
    
    public void push(int x)
    {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
        {
            minStack.push(x);
        }
    }
    
    public void pop()
    {
     if((stack.peek().equals(minStack.peek())))
     {
         minStack.pop();
     }
        stack.pop();
    }
    
    public int getMin()
    {
        return minStack.peek();
    }
    
    public int top()
    {
        return stack.peek();
    }
}
//T-O(1),S-O(n)



