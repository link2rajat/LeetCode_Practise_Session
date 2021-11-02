class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      if(nums==null || nums.length==0)
            return 0;
        
        
        int currentmax= 0;
        int maxsum = nums[0];
        int total=0;
        int currentmin=0; 
        int minsum = nums[0];
        for(int index=0;index<nums.length;index++)
        {
          int current_num = nums[index];
            
            currentmax = Math.max(current_num,currentmax+current_num);
            maxsum= Math.max(maxsum,currentmax);
            currentmin = Math.min(current_num,currentmin+current_num);
            minsum= Math.min(minsum,currentmin);
            total+=current_num;
        }
        
        return (maxsum>0)?Math.max(maxsum,total-minsum) : maxsum ;
            
    }
}//T-O(n),S-O(1)