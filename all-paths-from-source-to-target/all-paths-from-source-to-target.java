class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if(graph.length==0 || graph== null)
          return result;
        List<Integer> path = new ArrayList<>();
     
        path.add(0);
        dfs(0,graph.length-1,result,path,graph);
        return result;
    }
    
    void dfs(int source, int destination,List<List<Integer>> result, List<Integer> path , int[][] graph)
    {
        if(source==destination)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int nextNode: graph[source])
        {
            path.add(nextNode);
            dfs(nextNode,destination,result,path,graph);
            path.remove(path.size()-1);
        }
        
    }
}//T-O(N*2^N),S-O(N*2^N)