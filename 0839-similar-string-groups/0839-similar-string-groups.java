class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer,List<Integer>> adjGraph = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                   adjGraph.computeIfAbsent(i,k->new ArrayList<Integer>()).add(j); 
                   adjGraph.computeIfAbsent(j,k->new ArrayList<Integer>()).add(i); 
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adjGraph,visited);
                count++;
            }
        }
        return count;
    }
    
    boolean isSimilar(String s1,String s2){
        int diff =0;
        
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
            diff++;
        }
        return diff == 0 || diff == 2;
    }
    
    void dfs(int node,Map<Integer,List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        if(!adj.containsKey(node)){
            return;
        }
        
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                  dfs(neighbour,adj,visited);
            }
        }
    }
}