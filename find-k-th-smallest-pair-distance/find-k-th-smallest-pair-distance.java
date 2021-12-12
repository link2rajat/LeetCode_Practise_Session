class Solution {
    public int smallestDistancePair(int[] nums, int k) {
    
     Arrays.sort(nums);
     int low =0;
     int high = nums[nums.length-1]-nums[0];

        while(low<high)
            {
       
            int mid=(low+high)/2;
            
            int count=0,winStart=0;
            for(int winEnd=0;winEnd<nums.length;winEnd++)
            {
          
            while(nums[winEnd]-nums[winStart]>mid)
            {
                 winStart++;
            }
                 count+=winEnd-winStart;
            }
                
                if(count>=k)
                {
                  high = mid;
                }
                else{
                    low= mid+1;
                }
            }
            
        
     return low;   
        
    }
}// T-O(NlogW+NlogN) where W is nums[nums.length-1]-nums[0], S-O(1)