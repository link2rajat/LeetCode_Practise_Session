class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts = new int[k];
        int sum=0;
        
        for(int num:nums){
            sum+=(num%k+k)%k;
            counts[sum%k]++;
        }
        int result = counts[0];
        for(int count:counts){
            result+=(count*(count-1))/2;
        }
        return result;
    }
}//T-O(n+k),S-O(k)