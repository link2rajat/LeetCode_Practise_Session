class Solution {
    public int minimumAverageDifference(int[] nums) {
      int n = nums.length;
      int ans = -1;
      int minAvgDiff = Integer.MAX_VALUE;
      long currentPrefixSum =0;
      
        long totalSum =0;
        
        for(int num :nums){
            totalSum+=num;
        }
        
        for(int index=0; index<n; index++){
           currentPrefixSum+=nums[index];
            
            long leftAverage = currentPrefixSum;
            leftAverage/= (index+1);
            
            long rightAverage = totalSum - currentPrefixSum;
            
            if(index != n-1){
                 rightAverage/= (n - index - 1);
            }
            
            int currAvgDifference =(int)Math.abs(leftAverage-rightAverage);
            
            if(currAvgDifference < minAvgDiff){
                minAvgDiff = currAvgDifference;
                ans = index;
            }
        }
        
        return ans;
        
    }
} // T-O(n),S-O(1)