class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       List<Integer>[] graph = new List[n+1];
        for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<>();  
        for(int[] dislikeEdge : dislikes){
            graph[dislikeEdge[0]].add(dislikeEdge[1]);
            graph[dislikeEdge[1]].add(dislikeEdge[0]);
        }
        
        Integer[] colors = new Integer[n+1];
        
        for(int vertex=1;vertex<=n;vertex++){
            
            if(colors[vertex]==null && !fillColorDfs(vertex,colors,graph,1)){
                return false;
            }
        }
        return true;
    }//T-O(N+E),S-O(N+E)
    
    boolean fillColorDfs(int currentVertex,Integer[] colors, List<Integer>[] graph,int currentColor){
        colors[currentVertex] = currentColor;
        
        for(Integer neighbour : graph[currentVertex]){
            if(colors[neighbour]==null){
                if( !fillColorDfs(neighbour,colors,graph,currentColor*-1))
                return false;
            } else if(colors[neighbour]==currentColor) {
                return false;
            }
        }
        return true;
    }
}