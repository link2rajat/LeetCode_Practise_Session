class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer>  result1 = new HashSet<>();
        Set<Integer>  result2 = new HashSet<>();
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int num:nums1){
            set1.add(num);
        }
        
        for(int num:nums2){
            set2.add(num);
        }
        
         for(int num:nums1){
             if(!set2.contains(num)){
                 result1.add(num);
             }
         }
        
         for(int num:nums2){
             if(!set1.contains(num)){
                 result2.add(num);
             }
         }
        
        result.add(result1.stream().collect(Collectors.toList()));
        
        result.add(result2.stream().collect(Collectors.toList()));
        
        return result;
    }
}//T-O(N),S-(1)