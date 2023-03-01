class Solution {
    public int[] sortArray(int[] nums) {
        
        if(nums.length<=1)return nums;
        int mid = nums.length/2;
        int[] leftArray = Arrays.copyOfRange(nums,0,mid);
        int[] rightArray = Arrays.copyOfRange(nums,mid,nums.length);

      return merge(sortArray(leftArray),sortArray(rightArray));  
    }//T-O(nlogn),S-O(nlogn)
    
    int[] merge(int[] leftArray, int[] rightArray){
        int i=0,j=0,k=0;
        int m = leftArray.length;
        int n = rightArray.length;
        int[] temp = new int[m+n];
        
        
        while(i<m && j<n){
            if(leftArray[i]<rightArray[j]){
                temp[k++]=leftArray[i++];
            }else{
                temp[k++]=rightArray[j++];
            }
        }
        while(i<m){
                    temp[k++]=leftArray[i++];
                }
                
        while(j<n){
                    temp[k++]=rightArray[j++];
                }
        return temp;
    }
}