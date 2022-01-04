class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        if(nums.length<=1)
        {
            return false;
        }
        
        for(int index=0;index<nums.length;index++)
        {
            boolean dir = nums[index]>0;
            
            int slow,fast;
            
            slow=fast=index;
            
            while(true)
            {
                slow=nextIndex(slow,nums,dir);
                
                if(slow==-1)
                {
                    break;
                }

                fast=nextIndex(fast,nums,dir);
                
                if(fast==-1)
                {
                    break;
                }
                
                fast=nextIndex(fast,nums,dir);
                
                if(fast==-1)
                {
                    break;
                }
                
                if(fast==slow)
                {
                    return true;
                }
            }
        }
     return false;

    } //T-O(N^2),S-O(1)
    
    int nextIndex(int idx,int[] nums, boolean dir)
    {
        boolean new_dir = nums[idx]>0;
        
        if(new_dir != dir)
        {
            return -1;
        }
        int nextIdx = (idx+nums[idx])% nums.length;
        
        if(nextIdx<0)
        {
            nextIdx+= nums.length;
        }
        
        
        if(idx==nextIdx)
        {
            return -1;
        }
        
        return nextIdx;
    }
}