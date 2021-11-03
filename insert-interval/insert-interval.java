class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
 
        LinkedList<int[]> result = new LinkedList<>();
        
        int index=0;
        while(index<intervals.length && intervals[index][1]<newInterval[0])
        {
            result.add(intervals[index++]);
        }
        
        int[] mergeInterval  = newInterval;
        
        while(index<intervals.length && intervals[index][0]<=mergeInterval[1])
        {
            
            mergeInterval[0] = Math.min(mergeInterval[0],intervals[index][0]);
            mergeInterval[1] = Math.max(mergeInterval[1],intervals[index++][1]);
        
        }
        result.add(mergeInterval);
  while(index<intervals.length )
        {
            result.add(intervals[index++]);
        }
        
        
        return result.toArray(new int [result.size()][2]);

    }
}//T-O(n),S-O(n)