class Solution {
    
    public int firstMissingPositive(int[] nums) {
       int i=0;
        while(i<nums.length)
        {
            if(nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i]-1])
            {
                swap(i,nums[i]-1,nums);
            }
            else{
            i++;
            }
        }
        
        for(i=0;i<nums.length;i++)
        {
            if(i+1!=nums[i])
                return i+1;
            
        }
        return nums.length+1;
    }   
     
    void swap(int a , int b, int[] nums)
    {
        int temp= nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    
}//T-O(n),S-O(1)
    
    