class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod =1_000_000_007;
        Arrays.sort(nums);
        
        int[] power = new int[n];
        power[0] =1;
        for(int i=1;i<n;++i){
            power[i] =(power[i-1]*2)% mod;
        }
        
        int ans = 0;
        int left =0,right=n-1;
        
        while(left<=right){
            if(nums[left] + nums[right] <= target) {
                ans+=power[right-left];
                ans%=mod;
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}//T-O(nlogn),S-O(n)