class Solution {
    public int minReorder(int n, int[][] connections) {
        int count=0;
        Set<String> path = new HashSet<>();
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
           graph.put(i,new HashSet<>()); 
        }
        
        for(int[] con:connections)
        {
            String str = con[0] +","+con[1];
            path.add(str);
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }
         
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(0);
        
        boolean[] visited = new boolean[n];
        visited[0]=true;
     
        while(!bfsQueue.isEmpty())
        {
            Integer node = bfsQueue.poll();
            for(Integer neighbour: graph.get(node))
            {
                if(visited[neighbour]) continue;
                
                visited[neighbour]=true;
                
                if(!path.contains(neighbour+","+node))count++;
                bfsQueue.offer(neighbour);
            }
        }
        return count;
    }
}
//T-O(n),S-O(n) where n is # of nodes
