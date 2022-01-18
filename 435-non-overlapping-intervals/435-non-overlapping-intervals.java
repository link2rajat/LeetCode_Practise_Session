class Solution {
    
   class myComparator implements Comparator<int[]>{
       public int compare(int[] a, int[] b)
       {
           return a[0] -b[0];
       }
       
   }
       
    
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)return 0;

        Arrays.sort(intervals,new myComparator());
        
        int count=0;
        int prev = 0;
        for(int i=1;i<intervals.length;i++)
        {
         if(intervals[prev][1]>intervals[i][0])
         {
             count++;
             if(intervals[prev][1]>intervals[i][1])prev=i;
         }
            else
            {
                prev=i;
            }
        }
        
        return count;
        
    }
}//T-O(nlogn),S-O(1)