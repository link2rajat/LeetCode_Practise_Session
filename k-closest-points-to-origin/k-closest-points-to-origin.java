class Solution {
    public int[][] kClosest(int[][] points, int k) {
     
        int[][] result = new int[k][2];
     
        if(points.length==0 || k==0)
        {
            return result;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[] >((n1,n2)->n2[0]-n1[0]);
        
        for(int i=0;i<points.length;i++)
        {
            int[] entry = {distance(points[i]),i};
          if(pq.size()<k)
          {
              pq.add(entry);
          }
            
         else if(entry[0]<pq.peek()[0])
            {
                pq.poll();
                pq.add(entry);
            }
        }
        
        for(int i=0;i<k;i++)
        {
        int entry =pq.poll()[1];
        result[i]= points[entry];
        }        
        
        return result;        
    
    }//T-O(nlogk),S-O(k)
    
    
    int distance(int[] points)
    {
        return (points[0])*(points[0])+(points[1])*(points[1]);
    }
   
    
}