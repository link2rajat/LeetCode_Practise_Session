class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
       Map<Integer,Integer> frequencyMap = new HashMap<Integer,Integer>();
       
        for(int num: nums)
         {
          frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
         }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->frequencyMap.get(a)-frequencyMap.get(b));
       
        for(int num: frequencyMap.keySet())
        {
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        
        int[] result = new int[k];
        
        for(int i=k-1;i>=0;i--)
        {
            result[i]=pq.poll();
        }
        
    return result;
}
 
}//T-O(NLogk), S-O(N+k)
    
