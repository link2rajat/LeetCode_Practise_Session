class Solution {
    List<List<Integer>> result = new LinkedList<>();
        
    public List<List<Integer>> subsets(int[] nums) {
       
        backtrack(nums,new LinkedList<>(),0);
        
        return result;
    }

    void backtrack(int[] nums,List<Integer> subset,int index)
    {
      result.add(new LinkedList<>(subset));
        for(int i=index;i<nums.length;i++)
        {
             subset.add(nums[i]);
             backtrack(nums,subset,i+1);
             subset.remove(subset.size()-1);
       }
    }
}//T-O(2^N),S-O(N)