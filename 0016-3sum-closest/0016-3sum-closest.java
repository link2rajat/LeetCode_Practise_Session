class Solution {
    public int threeSumClosest(int[] nums, int target) {
       
        Arrays.sort(nums);
        int closestDiff=Integer.MAX_VALUE;
         int closestSum=Integer.MAX_VALUE;
        for(int index=0;index<nums.length;index++)
        {
            int first = index;
            
            int left = index+1;
            int right= nums.length-1;
         
            while(left<right)
            {
                int sum=nums[first]+nums[left]+nums[right];
                int diff = Math.abs(sum-target);
                if(sum<target)
                {
                    left++;
                }
                else{
                    right--;
                }
                if(diff<closestDiff)
                {
                    closestDiff=diff;
                    closestSum=sum;
                }
            }
            
        }
        
        return closestSum;
    }
}