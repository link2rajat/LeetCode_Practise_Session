class Solution {
    int longestPath = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer,List<Integer>> childrenGraph = new HashMap<>();
        for(int i=0;i<n;i++){
            childrenGraph.computeIfAbsent(parent[i],value->new ArrayList<Integer>()).add(i);
        }   
        dfs(0,childrenGraph,s);
        return longestPath;
    }//T-O(n),S-O(n)
    
    int dfs(int currentNode, Map<Integer,List<Integer>> children,String s){
        
        if(!children.containsKey(currentNode)){
            return 1;
        }
        
        int longestChain = 0, secondLongestChain = 0;
        
        for(int child:children.get(currentNode)){
            
            int longestChainWithChild = dfs(child,children,s);
            
            if(s.charAt(currentNode)==s.charAt(child)){
                continue;
            }
            if(longestChainWithChild>longestChain){
                secondLongestChain = longestChain;
                longestChain = longestChainWithChild;
            }else  if(longestChainWithChild > secondLongestChain){
                secondLongestChain = longestChainWithChild;
            }
        }
        longestPath = Math.max(longestPath,longestChain+secondLongestChain+1);
            return longestChain+1;
    }
}