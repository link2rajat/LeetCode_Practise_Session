public class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i=0;i< nums.length; i++)
        {
             hm.put(nums[i],i);
        }
        for (int i=0;i< nums.length; i++)
        {
         int other = target- nums[i];
         
         if(hm.containsKey(other) && hm.get(other) != i)
         {
             return new int[] {i,hm.get(other)};
         }
        }   
        throw new IllegalArgumentException("No two sums");
    }
    
}//T-O(n),S-O(n)