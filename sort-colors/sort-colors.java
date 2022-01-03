class Solution {
    public void sortColors(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int index=0;
        while(index<=high)
        {
            if(nums[index] ==0)
            {
                swap(low++,index++,nums);
            }
            
           else if(nums[index] == 2)
           {
               swap(index,high--,nums);
           }
            else if (nums[index] == 1)
            {
                index++;
            }
            
        }
    }
    
    void swap(int a,int b,int nums[])
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b]= temp;
    }
}//T-O(N),S-O(1)