class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low=0;
        int high= nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            boolean isEvenHalves = (high-mid)%2==0;
            //mid's duplicate partner to the right of it
            if(nums[mid+1]==nums[mid]){
                if(isEvenHalves){
                    low=mid+2;
                }else{
                    high=mid-1;
                }
            }//mid's duplicate partner to the left of it
            else if(nums[mid-1]==nums[mid]){
                if(isEvenHalves){
                    high=mid-2;
                }else{
                    low=mid+1;
                }
            }else{
                return nums[mid];
            }
        }
        return nums[low];
    }
}//T-O(logn),S-O(1)