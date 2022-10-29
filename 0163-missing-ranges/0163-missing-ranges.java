class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        int prev = lower-1;
            
         for(int i=0;i<=nums.length;i++)
         {
             int current = (i<nums.length) ? nums[i] : upper+1;
             if(prev+1<=current-1)
             {
                 result.add(format(prev+1,current-1));
             }
             prev=current;
         }
        return result;     
    }//T-O(N),S-O(1)
    
    String format(int prev,int next)
    {
        if(prev==next)
        {
            return String.valueOf(prev);
        }
        return prev+"->"+next;
    }
}