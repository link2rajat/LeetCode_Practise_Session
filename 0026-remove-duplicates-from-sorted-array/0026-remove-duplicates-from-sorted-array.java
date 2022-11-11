class Solution {
    public int removeDuplicates(int[] nums) {
    
    if(nums.length==0 )
       {
           return 0;
       }
        int k=0;
        for(int i=1;i<nums.length;i++)
        {
         if(nums[k]!=nums[i])
         {
           k++;
             nums[k]=nums[i];
         }

        }
        
        
       return k+1;
    }
}//T-O(n),S-O(1)