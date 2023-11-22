class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        int n=bombs.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int xi=bombs[i][0],yi=bombs[i][1],ri=bombs[i][2];
                int xj=bombs[j][0],yj=bombs[j][1];
                if((long)ri*ri>=(long)(xi-xj)*(xi-xj) +(long)(yi-yj)*(yi-yj)){
                    graph.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                }
            }
        }
            int answer=0;
            for(int i=0;i<n;i++){
                answer=Math.max(answer,bfs(i,graph));
            }
            return answer;
        }
    int bfs(int node,Map<Integer,List<Integer>> graph){
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()){
           int current = queue.poll();
            for(int neighbour: graph.getOrDefault(current,new ArrayList<>())){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        return visited.size();
    }
}