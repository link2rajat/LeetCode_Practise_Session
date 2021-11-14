class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     HashSet<Integer> hs = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]))
            {
                result.add(nums[i]);
            }
            hs.add(nums[i]);
        }
        
        return result;
    }
}//T-O(n),S-O(n)