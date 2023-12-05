class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         List<List<Integer>> answer = new ArrayList<>();
        if(graph.length==0 || graph==null){
            return answer;
        }
       List<Integer> path =new ArrayList<>();
        path.add(0);
        backtrack(graph,0,graph.length-1,path,answer);
        
        return answer;
    }
    
    void backtrack(int[][] graph,int source,int destination,List<Integer> current,List<List<Integer>> answer ){
        
        if(source==destination){
            answer.add(new ArrayList<>(current));
            return;
        }
        
        for(int neighour: graph[source]){
             current.add(neighour);
             backtrack(graph,neighour,destination,current,answer);
             current.remove(current.size()-1);

        }
    }
}