class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        boolean[] visit = new boolean[n];
        int[] indegree = new int[n];
        
        for(int edge : edges){
            if(edge !=-1){
                indegree[edge]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            visit[node] = true;
            int neighbour = edges[node];
            if(neighbour !=-1){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        
        int ans=-1;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                int neighbour = edges[i];
                int count =1;
                visit[i] = true;
                
                while(neighbour != i){
                    visit[neighbour] = true;
                    count++;
                    neighbour = edges[neighbour];
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
        
    }
}//T-O(n),S-O(n)