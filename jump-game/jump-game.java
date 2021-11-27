class Solution {
    public boolean canJump(int[] nums) {
        int result_index = nums.length-1;
        int index_max_reach=nums[0];
        
        for(int i=0;i<=index_max_reach;i++)
        {
         index_max_reach=Math.max(index_max_reach,i+nums[i]);
            
        if(index_max_reach>=result_index)return true;
            
        }
        
        return false;
    }
}//T-O(n),S-O(1)