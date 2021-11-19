class Solution {
    
    class UnionFind
    {
        
        int[] parent;
        int[] rank;
        
        public UnionFind(int n)
        {
            parent = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
            rank = new int[n];
        }
        
        public int find(int x)
        {
            while(parent[x]!= x)
            {
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }
        
        public boolean union(int node1, int node2)
        {
            int parNode1 = find(node1);
            int parNode2 = find(node2);
            
            if(parNode1==parNode2)
            {
                return false;
            }
            else if(rank[parNode1]>rank[parNode2])
            {
                parent[parNode2]=parNode1;
            }
            else if(rank[parNode1]<rank[parNode2])
            {
                parent[parNode1]=parNode2;
            }
            else{
                parent[parNode2]=parNode1;
                rank[parNode1]++;
            }
            return true;
        }
        
    }
    
    int MAX_EDGE_VAL=1000;
    
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind u = new UnionFind(MAX_EDGE_VAL+1);
        for(int[]edge: edges)
        {
            
            if(!u.union(edge[0],edge[1]))
                return edge;
        }
        throw new AssertionError();
        
    }
}

//T-O(N),S-O(N)