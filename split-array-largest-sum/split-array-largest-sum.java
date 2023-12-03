class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0;
        int right=0;

        for(int num:nums){
            left = Math.max(left,num);
            right+=num;
        }
        
        int minLargestSplitSum=0;
        
        while(left<=right){
            int maxSumAllowed = left+(right-left)/2;
            if(minimumSubArraysRequired(nums,maxSumAllowed)<=k){
                right=maxSumAllowed-1;
                minLargestSplitSum=maxSumAllowed;
            }else{
                left=maxSumAllowed+1;
            }
        }
        return minLargestSplitSum;
    }
    int minimumSubArraysRequired(int[] nums, int maxSum) {
        int currentSum=0;
        int splitRequired=0;
        for(int element: nums){
            if(currentSum+element<=maxSum){
                currentSum+=element;
            }else{
                currentSum=element;
                splitRequired++;
            }
        }
        return splitRequired+1;
    }
}