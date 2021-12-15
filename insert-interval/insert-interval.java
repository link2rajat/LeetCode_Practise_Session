class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<int[]>();

        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0])
        {
                result.add(intervals[i++]);
        }
        
        int[] mergeInterval = newInterval;
        
        while(i<intervals.length && intervals[i][0]<=mergeInterval[1])
        {
                mergeInterval[0] = Math.min(intervals[i][0],mergeInterval[0]);
                mergeInterval[1] = Math.max(intervals[i++][1],mergeInterval[1]);
        }
        result.add(mergeInterval);
        
         while(i<intervals.length)
        {
            
                result.add(intervals[i++]);
        }
        
        return result.toArray(new int [result.size()][2]);
        
    }
}//T-O(n),S-O(n)