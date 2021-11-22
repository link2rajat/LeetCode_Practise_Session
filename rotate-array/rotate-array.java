class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        swap(0,nums.length-1,nums);
        swap(0,k-1,nums);
        swap(k,nums.length-1,nums);
    }
    
    void swap(int start,int end,int[] nums)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}