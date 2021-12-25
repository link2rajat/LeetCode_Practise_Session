class Solution {
    
       int[] parent;
     
    public boolean isBipartite(int[][] graph) {

    parent = new int[graph.length];    
         for(int i=0;i<graph.length;i++)
            {
                parent[i]=i;
            }

         for(int i=0;i<graph.length;i++)
            {
          for(int j=0;j<graph[i].length;j++)
            {
            if( find(i)== find(graph[i][j]))
               {
                   return false;
               }
           union(graph[i][0],graph[i][j]);    
               
           }
         }
      return true;
    }
    
     private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        parent[parentY] = parentX;
    }
            
        public int find(int x)
        {
            while(x!=parent[x])
            {
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
       }

}//T-O(ElogV),S-O(V)