class Solution {
    public int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        for(int pile:piles){
            maxHeap.add(pile);
        }
        
        for(int i=0;i<k;i++){
            int current = maxHeap.poll();
            int remove = current/2;
            maxHeap.add(current-remove);
        }
        
        int ans=0;
        
        for(int pile:maxHeap){
            ans+=pile;
        }
        
        return ans;
    }
}//T-O(n+klogn),S-O(n)