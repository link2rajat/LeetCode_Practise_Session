class Solution {
  int total;
    public int findTargetSumWays(int[] nums, int target) {
        
        for(int num: nums)
        {
            total+=num;
        }
      
        int [][] memo = new int[nums.length][2*total+1];
       
        for(int [] mem: memo)
        {
            
            Arrays.fill(mem,Integer.MIN_VALUE);
        }
        
        return targetSum(nums,target,0,0,memo);
        
        
    }
    
    int targetSum(int[] nums, int target, int index, int currentSum, int[][] memo)
    {
        if(index==nums.length)
        {
            
            if(currentSum==target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        
        else 
        {
       
        if(memo[index][currentSum+total]!= Integer.MIN_VALUE)
        {
            return memo[index][currentSum+total];
        }
        
        
            int sum = targetSum(nums,target,index+1,currentSum+nums[index],memo);
            
            int diff = targetSum(nums,target,index+1,currentSum-nums[index],memo);
            
             memo[index][currentSum+total] = sum+diff;
        }
        
        return memo[index][currentSum+total];        
        
    }
}//T-O(n*t),S-O(n*t)