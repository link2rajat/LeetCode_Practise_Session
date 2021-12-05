
class Solution {
    
    public int maxProduct(int[] nums) {
        int min_sum=nums[0];
        int max_sum=nums[0];
        int result=max_sum;
        for(int i=1;i<nums.length;i++)
        {
          
            int temp=Math.max(nums[i],Math.max(max_sum*nums[i],min_sum*nums[i]));
            //for negative integer in the hope of geting a pair of negative number        
            min_sum=Math.min(nums[i],Math.min(max_sum*nums[i],min_sum*nums[i]));
   
            max_sum=temp;
            result= Math.max(max_sum,result);
        }
        return result;
    }
}//T-O(n),S-O(1)