class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        for(int[] interval: intervals){
            if(mergedList.isEmpty() || mergedList.getLast()[1]<interval[0]){
                mergedList.add(interval);
            }else{
               mergedList.getLast()[1] = Math.max(mergedList.getLast()[1],interval[1]); 
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }
}//T-O(nlogn),S-O(1)