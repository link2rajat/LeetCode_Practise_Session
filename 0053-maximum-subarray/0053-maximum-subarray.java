class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum= Math.max(num,sum+num);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}