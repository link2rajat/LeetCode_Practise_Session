class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    
        if(nums.length==0 || nums==null)
            return 0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==s)return 1;
        }
        

        int sum=0;
        int minsize=Integer.MAX_VALUE;
        int winStart=0;
        for(int winEnd=0;winEnd<nums.length;winEnd++)
        {
           sum+=nums[winEnd];
            while(sum>=s)
            { 
                minsize=Math.min(minsize,winEnd-winStart+1);
                sum-=nums[winStart];
                winStart++;
            }
        }
        
        return minsize==Integer.MAX_VALUE?0:minsize;
        
    }
}//T-O(n),S-O(1)