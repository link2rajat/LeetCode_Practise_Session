//https://www.youtube.com/watch?v=9CbzRhXOql8&ab_channel=CodingBeast
class Solution {
    
    int[] ans;
    List<List<Integer>> adjList;
    Set<Integer> visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        
        adjList = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[]e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        visited = new HashSet<>();
        
        dfs(0,labels);
        return ans;
    }//T-O(26*N),S-O(26*N)
    
    int[] dfs(int node,String labels){
        visited.add(node);
        int[] count = new int[26];
        for(int adj: adjList.get(node)){
            if(!visited.contains(adj)){
                int[] adjCount = dfs(adj,labels);
                for(int i=0;i<26;i++){
                    count[i]+=adjCount[i];
                }
            }
        }
        char ch = labels.charAt(node);
        count[ch-'a']++;
        ans[node]=count[ch-'a'];
        return count;
        
    }
}