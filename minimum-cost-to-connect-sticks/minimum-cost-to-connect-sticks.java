class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length==0 || sticks.length==1 )
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int stick: sticks)
        {
            pq.offer(stick);
        }
          int result=0;
        while(pq.size()>1)
        {
            int top = pq.poll();
            int top_2 = pq.poll();
            int new_max = top+top_2;
            result+=new_max;
            pq.offer(new_max);
        }
        
        return result;
    }
}//T-O(nlogk), S-O(n)