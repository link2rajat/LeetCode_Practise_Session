class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
            return nums;
        
        int winSize= 2*k+1;
        int n= nums.length;
        int[] avg = new int[n];
        Arrays.fill(avg,-1);
        
        if(winSize>n){
            return avg;
        }
        
        long windowSum=0;
        for(int i=0;i<winSize;++i){
            windowSum+=nums[i];
        }
        avg[k]=(int)(windowSum/winSize);
        
          for(int i=winSize;i<n;++i){
            windowSum+=nums[i]-nums[i-winSize];
                avg[i-k]=(int)(windowSum/winSize);
        }
        return avg;
    }
}