class Solution {
    public int firstMissingPositive(int[] nums) {
      
        int i=0;
          while (i<nums.length)
          {
           if(nums[i]<=nums.length && nums[i]>0 && nums[i]!=nums[nums[i]-1] )
           {
              swap(i,nums[i]-1,nums);
           }
              else{
                  i++;
              }
          }
        
        for(int j=0;j<nums.length;j++)
        {
            if(j+1 != nums[j])
            {
                return j+1;
            }
        }
               
        return nums.length+1;
        
    }//T-O(N),S-O(1)
    
    void swap(int a, int b, int[] nums)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    
}