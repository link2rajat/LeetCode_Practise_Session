class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
         result.add( new ArrayList<>());
        int subsetEnd=0;
        
        for(int i=0;i<nums.length;i++)
        {

            int subsetStart=(i>=1 && nums[i]==nums[i-1]) ?subsetEnd:0;
            
            subsetEnd= result.size();
           
            for(int j= subsetStart;j<subsetEnd;j++)
            {
             
            List<Integer> currentSet = new ArrayList<>(result.get(j));
            currentSet.add(nums[i]);
            result.add(currentSet);
            }
        }
        return result;
    }
}//T-O(n*2^n),S-O(logn(based on sorting space))