class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int m=queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        
        for(int j=0;j<queries.length;j++){
            
            int index = binarySearch(queries[j],nums);
            ans[j]=index;
        }
        return ans;
    }
    
    int binarySearch(int target,int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
           if(nums[mid]<=target){
              left=mid+1;
            }else{
                
                 right=mid-1;
            }
        }
        return nums[left]>target ? left:left+1;
    }
}