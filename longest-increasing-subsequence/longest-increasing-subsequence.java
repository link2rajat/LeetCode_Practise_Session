class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lisList = new ArrayList<>();
        
        lisList.add(nums[0]);
        
        for(int i=1;i<nums.length;i++)
        {
            int currentnum = nums[i];
            if(currentnum > lisList.get(lisList.size()-1))
            {
                 lisList.add(currentnum);
            }
            else
            {
                int getCurrentnumPos = binarySearchinAL(currentnum,lisList);
                lisList.set(getCurrentnumPos,currentnum);
            }
        }
        return lisList.size();
    }//T-O(nlogn),S-O(n),where n is # of element
    
    int binarySearchinAL(int num, ArrayList<Integer> lisList)
    {
        int low=0;
        int high=lisList.size()-1; 
        int mid;
        
        while(low<=high)
        {
            mid = low+(high-low)/2;
            
            if(lisList.get(mid)== num)
            {
                return mid;
            }
            else if(lisList.get(mid)<num)
            {
                low=mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
    
}