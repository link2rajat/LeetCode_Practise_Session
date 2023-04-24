//https://leetcode.com/problems/last-stone-weight/solution/ ap3 
class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0)
            return 0;
        else if(stones.length == 1)
            return stones[0];
        int result;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone:stones)
        {
            pq.add(stone);
        }
    
        while(pq.size()>1)
        {
        int bigger = pq.remove();
        int secondbigger = pq.remove();
        
        if(bigger!=secondbigger)
            pq.add(bigger-secondbigger);
       
        }
        
       return pq.isEmpty()?0:pq.remove();
    }
    
            
    
}