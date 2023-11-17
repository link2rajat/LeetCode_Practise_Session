class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        return dfs(graph,source,destination,seen);
    }
    boolean dfs(Map<Integer,List<Integer>> graph, int currentVertex, int destination, boolean[] seen){
        if(currentVertex==destination){
            return true;
        }
        if(!seen[currentVertex]){
            seen[currentVertex]=true;
            for(Integer neighbour:graph.get(currentVertex)){
                if(dfs(graph,neighbour,destination,seen)){
                    return true;
                }
            }
        }
        return false;
    }
}