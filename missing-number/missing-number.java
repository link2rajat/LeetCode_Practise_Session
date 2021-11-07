class Solution {
    public int missingNumber(int[] nums) {
        
        int index=0,temp=0;
        //using cyclic sort assigning number to it's index
        while(index<nums.length)
        {
            if(nums[index]<nums.length && index!=nums[index])
            {
                temp = nums[nums[index]];
                nums[nums[index]]= nums[index];
                nums[index]=temp;
            }
            else{
                index++;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if( i!=nums[i])
            {
               return i; 
            }
        }
        
        return nums.length;
    }
}//T-O(n),S-O(1)