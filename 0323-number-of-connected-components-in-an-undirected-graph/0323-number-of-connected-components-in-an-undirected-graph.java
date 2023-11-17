class Solution {
     
    public int countComponents(int n, int[][] edges) {
       boolean[] seen = new boolean[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++){
            seen[i]=false;
            graph.put(i,new ArrayList<>());
        }
        
        for(int [] edge:edges){
            int fromEdge =edge[0];
            int toEdge =edge[1];
            graph.get(fromEdge).add(toEdge);
            graph.get(toEdge).add(fromEdge);
        }
         int ans = 0; 
        for(int i=0;i<n;i++){
             if (!seen[i]) {
                // add all nodes of a connected component to the set
                ans++;
                seen[i] = true;
                dfs(graph, seen, i);
            }
        }
        return ans;
    }
    
    
   public void dfs( Map<Integer,List<Integer>> graph,  boolean[] seen,int node) {
        for (int neighbor: graph.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                 dfs(graph, seen, neighbor);
            }
        }
    }
}