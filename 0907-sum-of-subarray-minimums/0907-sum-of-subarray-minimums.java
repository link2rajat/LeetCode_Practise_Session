class Solution {
    public int sumSubarrayMins(int[] arr) {
     
        
        long result = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long)1e9+7;
        
        stack.push(-1);
        
        for(int idx=0;idx<arr.length+1;idx++)
        {
            int currVal =(idx<arr.length) ? arr[idx] :0;
            
            while(stack.peek() !=-1 && currVal<arr[stack.peek()]) {
                int midIndex =stack.pop();
                int index = stack.peek();
                int left = midIndex-index;
                int right = idx - midIndex;
                
                long addVal = (long)(left * right * (long)arr[midIndex]) % M ;
                result+=addVal;
                result%=M;
            }
            stack.push(idx);
        }
        
        return (int)result;
        
    }
}