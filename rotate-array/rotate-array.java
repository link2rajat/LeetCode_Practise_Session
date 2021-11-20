class Solution {
    public void rotate(int[] nums, int k) {
       // if k is more than n
        int n=nums.length-1;
        k=k%nums.length; 
        reverse(0,n,nums);
        reverse(0,k-1,nums);
        reverse(k,n,nums);
    }
    
    void reverse(int start,int end,int[]nums)
    {
      while(start<end)
        {
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        
    }
}
//T-O-(n),S-O(1)