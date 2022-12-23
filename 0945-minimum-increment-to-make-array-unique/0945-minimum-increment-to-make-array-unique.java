class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=prev){
                prev++;
                count+=(prev-nums[i]);
            } else {
                prev = nums[i];
            }
        }
        return count;
    }
}//T-O(nlogn),S-O(1)