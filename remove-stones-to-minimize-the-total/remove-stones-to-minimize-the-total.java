class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for(int p:piles){
            pq.offer(p);
        }
      for(int i=0;i<k;i++){
            int p = pq.remove();
            int q=p/2;
            pq.offer(p-q);
        
        }
        int sum=0;
        for(int num:pq){
            sum+=num;
        }
        
        return sum;
    }
}