class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left =1;
        int right=findMax(nums);
        int ans=-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            int sum=check(nums,mid,threshold);
            if( sum<=threshold){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    
    int check(int[] nums,int divisor,int threshold){
        int sum=0;
        for(int num:nums){
            sum+=Math.ceil((1.0* num)/divisor);
        }
        
        return sum;
    }
    
    int findMax(int[] nums){
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        return max;
    }
}