class Solution {
    public int minScore(int n, int[][] roads) {
      
        Map<Integer,List<List<Integer>>> adjList = new HashMap<>();
        
        for(int[] road: roads){
  
            adjList.computeIfAbsent(road[0],k-> new ArrayList<List<Integer>>()).add(Arrays.asList(road[1],road[2]));
            adjList.computeIfAbsent(road[1],k-> new ArrayList<List<Integer>>()).add(Arrays.asList(road[0],road[2]));
        }
        return bfs(n,adjList);
    }//T-O(n+e),S-O(n+e)
    
    int bfs(int n,Map<Integer,List<List<Integer>>> adjList){
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        
        queue.offer(1);
        visit[1] = true;
        
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            
            if(!adjList.containsKey(node)){
                continue;
            }
            for(List<Integer> edge : adjList.get(node)){
                ans = Math.min(ans,edge.get(1));
                if(!visit[edge.get(0)]){
                    visit[edge.get(0)] = true;
                    queue.offer(edge.get(0));
                }
            }
        }
        return ans;
    }
}