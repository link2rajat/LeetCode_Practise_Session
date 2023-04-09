class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[n];
        
        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0],k->new ArrayList<Integer>()).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        int[][] count = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        int ans=1,nodeSeen=0;
        
        while(!queue.isEmpty()){
         int node = queue.poll();
            ans = Math.max(ans,++count[node][colors.charAt(node)-'a']);
            nodeSeen++;
            
            if(!adj.containsKey(node)){
                continue;
            }
            
            for(int neighbour:adj.get(node)){
                for(int i=0;i<26;i++){
                    count[neighbour][i] = Math.max(count[neighbour][i],count[node][i]);
                }
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        return nodeSeen < n ? -1:ans;
        
    }
}//T-(26*(m+n)),S-O(m+26*n)