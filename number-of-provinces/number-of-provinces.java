class Solution {
    
    class UnionFind
    {
        int count=0;
        
        int[] rank;
        int[] parent;
      
        public UnionFind(int n)
        {
            count=n;
            rank = new int[n];
            parent = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        }
        public int find(int x)
        {
            while(x!=parent[x])
            {
                parent[x]=parent[parent[x]];
                x=parent[x];
            }
            return x;
        }
        
        public void union(int m, int n)
        {
            int L = find(m);
            int R = find(n);
            if(L==R)return;
            if(rank[L]>rank[R])
            {
                parent[R]=L;
            }
            else
            {
                parent[L]=R;
                if(rank[R]==rank[L])
                    rank[L]++;
               
            }
            count--;
        }
        
        public int count()
        {
            return count;
        }
        
    }
    
    
    
    public int findCircleNum(int[][] M) {
     int n = M.length;
    UnionFind u = new UnionFind(n);
    for(int i=0;i<n-1;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            
            if(M[i][j]==1)
                u.union(i,j);
        }
    }
       
    return u.count();
        
    
    }
}

//T-O(n^2),S-O(n)