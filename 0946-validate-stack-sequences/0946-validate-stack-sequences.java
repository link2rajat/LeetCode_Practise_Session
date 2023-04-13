class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int N=pushed.length;
        int j=0;
        
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && j<N && popped[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        return j==N;
    }
}//T-O(N),S-O(N)