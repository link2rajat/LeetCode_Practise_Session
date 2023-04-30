class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);
        
        int edgeRequired = 0;
        
        for(int[] edge:edges){
            if(edge[0]==3){
               edgeRequired+=(Alice.performUnion(edge[1],edge[2])| Bob.performUnion(edge[1],edge[2]));
            }
        }
        
        for(int[] edge:edges){
            if(edge[0]==1){
               edgeRequired+=(Alice.performUnion(edge[1],edge[2]));
            } else if(edge[0]==2){
               edgeRequired+=(Bob.performUnion(edge[1],edge[2]));
            }
        }
        
        if(Alice.isConnected() && Bob.isConnected()){
            return edges.length - edgeRequired;
        }
        return -1;
    }
    
    class UnionFind{
        int[] representative;
        int[] componenetSize;
        
        int componenets;
        
        public UnionFind(int n){
            componenets = n;
            representative = new int[n+1];
            componenetSize = new int[n+1];
            
            for(int i=0;i<=n;i++){
                representative[i] = i;
                componenetSize[i] = i;
            }
        }
        
        int findRepresentative(int x){
            if(representative[x]==x){
                return x;
            }
            return representative[x] = findRepresentative(representative[x]);
        }
        
        int performUnion(int x, int y){
          x = findRepresentative(x); y = findRepresentative(y);
            
            if(x==y){
                return 0;
            }
            
            if(componenetSize[x] > componenetSize[y]){
                componenetSize[x] +=componenetSize[y];
                representative[y] =x;
            }else{
                componenetSize[y] +=componenetSize[x];
                representative[x] =y;
            }
            componenets--;
            return 1;
        }
        
        boolean isConnected(){
            return componenets == 1;
        }
    }
}