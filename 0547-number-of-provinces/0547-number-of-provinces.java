class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n=isConnected.length;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int i=0;i<n;i++){
          if(!graph.containsKey(i))
            graph.put(i,new ArrayList<>());
            
            for(int j=i+1;j<n;j++){
                if(!graph.containsKey(j))
                    graph.put(j,new ArrayList<>());
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
              }
            }
        }
        int answer=0;
        for(int i=0;i<n;i++){
            if(!seen.contains(i)){
                seen.add(i);
                answer++;
                dfs(i,seen,graph);
            }
        }
        return answer;
    }//T-O(N),S-O(N)
    
    void dfs(int node,Set<Integer> seen,Map<Integer,List<Integer>> graph){
        for(Integer neighbour:graph.get(node)){
           if(!seen.contains(neighbour)){
                seen.add(neighbour);
               dfs(neighbour,seen,graph);
           }
        }
    }
}