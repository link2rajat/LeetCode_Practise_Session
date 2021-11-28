class Solution {
    public int maxProfit(int[] prices) {
      int max_Profit=0;
        int current_max=0;
        
        for(int i=1;i<prices.length;i++)
        {
            current_max=Math.max(0,current_max+=prices[i]-prices[i-1]);
            max_Profit=Math.max(max_Profit,current_max);
            
        }
        return max_Profit;
        
    }
}//T-O(n),S-O(1)