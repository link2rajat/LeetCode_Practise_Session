class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      
        if(nums1.length > nums2.length)
        {
           return intersect(nums2,nums1);
        }        
    
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int n1: nums1)
        {
           map.put(n1, map.getOrDefault(n1,0)+1);
        }
        
        int k = 0;
        for(int n2 : nums2)
        {
            int count = map.getOrDefault(n2,0);
            
            if(count>0)
            {
                nums1[k++]=n2;
                map.put(n2,count-1);
            }
        }
        
        return Arrays.copyOfRange(nums1,0,k);
    }
} // T-O(n+m) , S-O(min(n,m))