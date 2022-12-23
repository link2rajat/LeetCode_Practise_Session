class Solution {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int hold = Integer.MIN_VALUE;
        int reset = 0;
        
        for(int p: prices){
            int prevSold = sold;
            sold = hold + p;
            hold = Math.max(hold, reset-p);
            reset = Math.max(reset, prevSold);
        }
        
        return Math.max(sold,reset);
    }
}//T-O(n),S-O(1)