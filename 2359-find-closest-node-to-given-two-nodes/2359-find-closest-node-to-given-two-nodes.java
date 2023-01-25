class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n],dist2 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        
        bfs(node1,edges,dist1);
        bfs(node2,edges,dist2);
        
        int minDistNode=-1,minDistTillNow=Integer.MAX_VALUE;
        
        for(int currentNode=0;currentNode<n;currentNode++){
            if(minDistTillNow>Math.max(dist1[currentNode],dist2[currentNode]))
            {
                minDistNode = currentNode;
                minDistTillNow = Math.max(dist1[currentNode],dist2[currentNode]);
            }
        }
    return minDistNode;
    }//T-O(n),S-O(n)
    public void bfs(int startNode,int[] edges,int[] dist) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited,Boolean.FALSE);
        dist[startNode]=0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            if(visited[node]){
                continue;
            }
            
            visited[node]=true;
            int neighbour = edges[node];
            if(neighbour!=-1 && !visited[neighbour]){
                dist[neighbour]=1+dist[node];
                q.offer(neighbour);
            }
        }
    }
}