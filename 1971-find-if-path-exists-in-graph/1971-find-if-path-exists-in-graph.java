class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination){

        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        constructGraph(n,edges,graph);
        boolean[] visited = new boolean[n];
        return findPath(graph,source,destination, visited);
    }//T-O(n+m),S-O(n+m)
    
    void constructGraph(int n,int[][] edges,Map<Integer,List<Integer>> graph){
        for(int index=0;index<n;index++){
            graph.put(index,new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    
    boolean findPath(Map<Integer,List<Integer>> graph, int source, int destination, boolean[] visited){
        
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(source);
        visited[source]=true;
        
        while(!bfsQueue.isEmpty()){
            Integer vertexCurrentVisit = bfsQueue.poll();
            if(vertexCurrentVisit==destination){
                    return true;
                }
            for(Integer neighbour: graph.get(vertexCurrentVisit)){
                if(!visited[neighbour])
                   { 
                visited[neighbour]=true;
                bfsQueue.add(neighbour);
                }
            }
        }
        return false;
    }
}