class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        result[0]= improvedBinarySearch(nums,target,true);
        if(result[0]==-1){
            result[1]=-1; 
        }
           result[1]= improvedBinarySearch(nums,target,false);
        return result;
    }//T-O(log n),S-O(1)
    
    int improvedBinarySearch(int[] nums, int target,boolean leftFlag){
        
        int size=nums.length;
        int left=0;
        int right = size-1;
        int index=-1;
        while(left<=right){
             int mid= left + (right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                index=mid;
                    if(leftFlag){
                      right=mid-1;  
                    }else{
                     left=mid+1; 
                    }
            }
        }
        return index;
        
    }
}