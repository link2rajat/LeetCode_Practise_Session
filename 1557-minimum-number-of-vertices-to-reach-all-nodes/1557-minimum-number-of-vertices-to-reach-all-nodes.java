class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] inComingEdgeExists = new boolean[n];
        
        for(List<Integer> edge : edges){
            inComingEdgeExists[edge.get(1)] = true;
        }
        
        List<Integer> requiredNodes = new ArrayList<>();
        
            for(int i=0;i<n;i++){
                if(!inComingEdgeExists[i]){
                    requiredNodes.add(i);
                }
            }
        return requiredNodes;
    }
}//T-O(N+E),S-O(N)