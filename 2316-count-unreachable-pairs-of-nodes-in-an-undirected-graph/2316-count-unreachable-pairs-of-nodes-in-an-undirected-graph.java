class Solution {
    public long countPairs(int n, int[][] edges) {
      
        Map<Integer,List<Integer>> adj = new HashMap<>();
        
        for(int[] edge: edges){
            adj.computeIfAbsent(edge[0],k-> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k-> new ArrayList<Integer>()).add(edge[0]);
        }
        
        long numOfPairs = 0;
        long size = 0;
        long remain = n;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                size = dfs(i,adj,visited);
                numOfPairs += size *(remain-size);
                remain -=size;
            }
        }
        return numOfPairs;
    }//T-O(n+e),S-O(n+e)
    
    int dfs(int node,Map<Integer,List<Integer>> adj, boolean[] visit){
        int count=1;
        visit[node] = true;
        
        if(!adj.containsKey(node)){
            return count;    
        }
        
        for(int neighbor:adj.get(node)){
            if(!visit[neighbor]){
                count+=dfs(neighbor,adj,visit);
            }
        }
        return count;
    }
}