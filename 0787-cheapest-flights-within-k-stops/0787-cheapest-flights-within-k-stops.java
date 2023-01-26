class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[][] adj = new int[n][n];
        
        for(int [] flight: flights)
        {
            adj[flight[0]][flight[1]]=flight[2];
        }
        //Sort based on min cost
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1,n2)->(n1[0]-n2[0]));
                                                  
        minHeap.add(new int[]{0,src,0});
        
        HashMap<Integer,int[]> seen = new HashMap<>();
        while(!minHeap.isEmpty())
        {
            int[] flightstation = minHeap.poll();
            
            int cost = flightstation[0],currentStation=flightstation[1], stopCount=flightstation[2];
            
            if(seen.containsKey(currentStation) && seen.get(currentStation)[0]<cost &&seen.get(currentStation)[1]<stopCount)continue;
            seen.put(currentStation, new int[]{cost,stopCount});
            if(currentStation==dst)
            {
                return cost;
            }
            if(stopCount>k)
            {
            continue;
            }
            
               for(int nextStation=0;nextStation<n;nextStation++)
               {
                   if(adj[currentStation][nextStation]>0)
                   {
                       minHeap.add(new int[]{cost+adj[currentStation][nextStation],nextStation,stopCount+1});
                   }
               }
            
        }
        
        return -1;
    }
}//T-O(V^2 * log V),S-O(V^2)V is space occupied by adjancy matrix and priority queue