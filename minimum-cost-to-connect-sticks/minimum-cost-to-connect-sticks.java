class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int stick:sticks){
            pq.offer(stick);
        }
        int ans=0;
        while(pq.size()>1){
            int stick1= pq.remove();
            int stick2=pq.remove();
            int sum= stick1+stick2;
            ans+=sum;
            pq.offer(sum);
        }
        return ans;
    }
}