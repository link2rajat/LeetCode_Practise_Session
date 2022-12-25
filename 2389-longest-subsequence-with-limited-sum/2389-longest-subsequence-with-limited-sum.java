class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        
        int n =nums.length;
        int m = queries.length;
        int[] result = new int[m];
        Arrays.sort(nums);
        for(int index=1;index<n;index++){
            nums[index]+=nums[index-1];
        }
        
        for(int i=0;i<m;i++){
            result[i] = findSumIndexBinarySearch(queries[i],nums);
        }
        return result;        
    }//T-O((n+m)logn)),S-O(n)
    
    int findSumIndexBinarySearch(int target,int[] nums){
        
        int left =0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<=target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    
}