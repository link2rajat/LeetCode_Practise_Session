class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge:edges){
            adj.computeIfAbsent(edge[0],value->new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],value->new ArrayList<Integer>()).add(edge[0]);
        }
        return dfs(0,-1,adj,hasApple);
    }//T-O(n),S-O(n)

    int dfs(int node,int parent,Map<Integer,List<Integer>> adj, List<Boolean> hasApple){
        if(!adj.containsKey(node)){
            return 0;
        }
        
        int totalTime=0,childTime=0;
        
        for(int child : adj.get(node)){
            if(child==parent){
                continue;
            }
            childTime = dfs(child,node,adj,hasApple);
            if(childTime>0 || hasApple.get(child)){
              totalTime+=childTime+2;
            }
        }
        return totalTime;
    }
}