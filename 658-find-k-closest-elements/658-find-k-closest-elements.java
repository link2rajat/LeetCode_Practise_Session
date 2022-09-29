class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        int left=0;
        int right= arr.length-k;

        
        while(left<right)
        {
            int mid = left+ (right-left)/2;
            
            if(x-arr[mid]>arr[mid+k]-x)
            {
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        
        for(int index=left;index<left+k;index++)
        {
            result.add(arr[index]);
        }
        
    return result;
        
    }
}
//T-O(log(N-k)+k) , S-O(1) where N is length of array