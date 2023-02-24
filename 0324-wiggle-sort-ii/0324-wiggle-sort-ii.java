class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        int[] result = new int[n];
        
        Arrays.sort(nums);
        
        int i=1;
        int j = n-1;
        
        while(i<n){
            result[i]=nums[j];
                i+=2;
                j--;
        }
        i=0;
        
        while(i<n){
            result[i]=nums[j];
                i+=2;
                j--;
        }
        
        for(int k=0;k<n;k++){
            nums[k]=result[k];
        }
        
    }
}//T-O(nlogn),S-O(n)