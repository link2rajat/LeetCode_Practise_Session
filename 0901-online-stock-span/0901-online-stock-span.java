//https://leetcode.com/problems/online-stock-span/discuss/640358/JAVA-Solution-With-visualization-and-easy-explained!
class StockSpanner {

    Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int spanCount=1;
        while(!stack.isEmpty() && price >=stack.peek()[0])
        {
         spanCount+=stack.pop()[1];  
        }
        stack.push(new int[]{price,spanCount});
        return spanCount;
    }
}//T-O(1),S-O(n)

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */