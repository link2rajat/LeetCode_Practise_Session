class Solution {
    public int removeStones(int[][] stones) {
        
        int n = stones.length;
        List<Integer>[] adjList = new ArrayList[n];
        
        for(int i=0;i<n;i++)
        {
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(hasSameRoworCol(stones[i],stones[j]))
                {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
                
            }
        }
        
        int count = 0;
        
        int[] visited = new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                count++;
                dfs(stones,adjList,visited,i);
            }
            
        }
        
        return n-count;
    }//T-O(N^2*+ E),S-(N+E)
    
    boolean hasSameRoworCol(int[] a , int[] b)
    {
        return a[0] == b[0] || a[1] == b[1];
    }
    
    void dfs(int[][] stones,List<Integer>[] adjList, int[] visited, int source)
    {
        visited[source]=1;
        
        for(Integer neighbour: adjList[source])
        {
            if(visited[neighbour]==0)
            {
                dfs(stones,adjList,visited,neighbour);
            }
        }
        
    }
}