class Solution {
    public int longestOnes(int[] nums, int k) {
    
        int winStart=0;
        
        int winEnd=0;
        
        for(winEnd=0;winEnd<nums.length;winEnd++)
        {
            
           if(nums[winEnd]==0)
           {
               k--;
           }
            if(k<0 && nums[winStart++]==0)
            {
                k++;
                
            }
        }
        return winEnd-winStart;
    }
}//T-O(n),S-O(1)