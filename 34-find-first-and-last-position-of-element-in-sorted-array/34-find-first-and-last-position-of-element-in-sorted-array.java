class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1,-1};
        
        result[0] = search(nums,target,false);
        
        if(result[0]== -1)
        {
            return result;
        }
        
        result[1] = search(nums,target,true);
            
        return result;
        
    }//T-O(logn) , S-O(1)
    
    
    int search(int[] nums, int target, boolean flag)
    {
        int low =0;
        int high = nums.length-1;
        int keyIdx=-1;

        while(low<=high)
        {
             int mid = low+(high-low)/2;
       
            if(target>nums[mid])
            {
                low = mid+1;
            }
            else if(target<nums[mid])
            {
                high = mid-1;
            }
            else
            {
                keyIdx =mid;
                if(flag)
                {
                   low = mid+1; 
                }
                    else
                    {
                        high = mid-1;
                    }
            }
        }
        return keyIdx;
    }
        
}