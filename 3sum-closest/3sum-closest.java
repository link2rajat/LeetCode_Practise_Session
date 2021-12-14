class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int diff= Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length && diff!=0;i++)
        {
        
        int low=i+1;
        int high=nums.length-1;
        while(low< high)
        {
            int sum=nums[low]+nums[high]+nums[i];
            if(Math.abs(target-sum)<Math.abs(diff))
            {
                diff = target-sum;
            }
            else if(sum>target)
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        
    }
         return target-diff;
 }
}//T-O(nlogn+n^2),S-O(n)based on sorting implementation