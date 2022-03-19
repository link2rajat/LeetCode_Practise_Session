class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> summapper = new HashMap<Integer,Integer>();
        summapper.put(0,1);
        int sum=0;
        int count=0;
        for(int n: nums)
        {
            sum+=n;
            if(summapper.containsKey(sum-k))
                count+=summapper.get(sum-k);
            
            summapper.put(sum,summapper.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}//T-O(n),S-O(n)