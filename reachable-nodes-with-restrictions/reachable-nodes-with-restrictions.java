class Solution {
    int ans=0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
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
        
        for(int r: restricted){
           seen[r]=true; 
        }
        
        dfs(0,graph,seen);
        return ans;
    }
    
    void dfs(int current, Map<Integer,List<Integer>> graph,boolean[] seen){
        ans++;
        seen[current]=true;
            
            for(Integer neighbour:graph.get(current)){
                if (seen[neighbour]==false){ 
                  dfs(neighbour,graph,seen);
                    }
            }
    }
}