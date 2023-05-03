class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> resultList = new ArrayList<>();
      
        resultList.add(findDifferenceHelper(nums1,nums2));
        
        resultList.add(findDifferenceHelper(nums2,nums1));
      
        
        return resultList;
    }
    
     List<Integer> findDifferenceHelper(int[] nums1,int[] nums2){
        
         Set<Integer>  result = new HashSet<>();
          Set<Integer> set = new HashSet<>();
         for(int num:nums2){
            set.add(num);
        }
         
           for(int num:nums1){
             if(!set.contains(num)){
                 result.add(num);
             }
         }
        
         
         return new ArrayList<>(result);
    }
}//T-O(N),S-(1)