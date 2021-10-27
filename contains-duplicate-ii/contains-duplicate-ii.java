class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<nums.length;i++)        
          {
        
            if(i>k)hashSet.remove(nums[i-k-1]);
            
            if(!hashSet.add(nums[i]))return true;
        }
        
        return false;
        
    }
    //T-O(n),S -O(min(k,n))
        
}