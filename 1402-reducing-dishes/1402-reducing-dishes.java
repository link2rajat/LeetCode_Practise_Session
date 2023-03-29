class Solution {
    public int maxSatisfaction(int[] satisfaction) {
      
        Arrays.sort(satisfaction);
        
        int maxSatisfaction =0;
        int suffixSum =0;
        
        for(int i=satisfaction.length-1;i>=0 && suffixSum+satisfaction[i]>0;i--){
            
            suffixSum+=satisfaction[i];
            
            maxSatisfaction+=suffixSum;
        }
        return maxSatisfaction;
    }
}//T-O(NlogN),S-O(NlogN)