class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int[] ans = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0;i<T.length;i++)
        {
            while(!stack.isEmpty() && T[i]>T[stack.peek()])
            {
                int prev = stack.pop();
                ans[prev] = i-prev;
            }
            stack.push(i);
            
        }
        
        return ans;
        
    }
}//T-O(n),S-O(n)