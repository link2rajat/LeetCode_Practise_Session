class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq.addAll(Arrays.asList(boxTypes));
        int maxUnits=0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int boxSize=Math.min(truckSize,top[0]);
            maxUnits+=boxSize*top[1];
            truckSize-=boxSize;
            if(truckSize==0){
                break;
            }
        }
        return maxUnits;
    }
}