class Solution {
    public int longestOnes(int[] nums, int k) {
      int winleft=0;
      int zeroCount=0;
        int winSize=0;
        for(int winRight=0;winRight<nums.length;winRight++){
            if(nums[winRight]==0){
               zeroCount++; 
            }
            while(zeroCount>k){
                if(nums[winleft]==0){
               zeroCount--; 
            }
                    winleft++;
            }
            winSize=Math.max(winSize,winRight-winleft+1);
        }
        return winSize;
        
    }
}