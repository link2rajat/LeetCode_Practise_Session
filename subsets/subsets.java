class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        result.add(subset);
       
        for(int element: nums)
        {
            int subsetsize = result.size();
            for(int index=0;index< subsetsize;index++)
            {
              List<Integer> newsubset = new ArrayList<>(result.get(index));
                newsubset.add(element);
                result.add(newsubset);
            }
        }
        return result;
    }
}//T-O(2^N),S-O(2^N)