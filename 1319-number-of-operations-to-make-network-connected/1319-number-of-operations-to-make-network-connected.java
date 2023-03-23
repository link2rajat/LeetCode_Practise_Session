class Solution {
    public int makeConnected(int n, int[][] connections) {
      if(connections.length < n-1){
          return -1;
      } 
        
      Map<Integer,List<Integer>> adjList = new HashMap<>();
        
        for(int[] connection : connections){
           adjList.computeIfAbsent(connection[0],k-> new ArrayList<Integer>()).add(connection[1]);
                adjList.computeIfAbsent(connection[1],k-> new ArrayList<Integer>()).add(connection[0]);
        }
        
        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
              numberOfConnectedComponents++;
                dfs(i,adjList,visit);
            }
        }
        return numberOfConnectedComponents -1;
    }//T-O(n+e),S-O(n+e)
    
    public void dfs(int node, Map<Integer,List<Integer>> adj, boolean[] visit){
      
        visit[node] = true;
        
        if(!adj.containsKey(node)){
            return;
        }
        
        for(int neighbour : adj.get(node)){
            if(!visit[neighbour]) {
                visit[neighbour] = true;
                dfs(neighbour,adj,visit);
            }
        }
        
    } 
}