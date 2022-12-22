class Solution {
    List<Integer>[] graph;
    int[] dist;
    int[] count;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new List[n];
        dist = new int[n];
        count = new int[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] edge: edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        postOrder(0,-1);
        preOrder(0,-1);
        
        return dist;
    }//T-O(N),S-O(N)
    
    void postOrder(int root,int prev){
        for(int next: graph[root]) {
            if(next==prev) continue;
            postOrder(next,root);
           
            dist[root]+=dist[next]+count[next]; 
            count[root]+=count[next];
         }
         count[root]++;         
    }
                  
    void preOrder(int root,int prev){
        for(int next:graph[root]){
            if(next==prev) continue; 
            dist[next] = dist[root]+graph.length -count[next] -count[next];
            preOrder(next,root);
        }
    }
}