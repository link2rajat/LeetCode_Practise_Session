class UnionFind{
    int[] parent;
    int[] rank;
    
    public UnionFind(int size){
        parent = new int[size];
        for(int i=0;i<size;i++){
            parent[i]=i;
        }
        rank = new int[size];
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y){
        int xSet =find(x), ySet = find(y);
        if(xSet==ySet){
            return;
        }else if(rank[xSet]<rank[ySet]){
            parent[xSet]=ySet;
        }else if(rank[xSet]>rank[ySet]){
            parent[ySet]=xSet;
        }else{
            parent[ySet] = xSet;
            rank[xSet]++;
        }
    }
}
class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
     Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[]edge:edges){
            int a = edge[0],b = edge[1];
            adj.computeIfAbsent(a,val->new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b,val->new ArrayList<Integer>()).add(a);
        }
        int n = vals.length;
        
        TreeMap<Integer,List<Integer>> valueToNodes = new TreeMap<>();
        
        for(int i=0;i<n;i++){
            valueToNodes.computeIfAbsent(vals[i],value->new ArrayList<Integer>()).add(i);
        }
        
        UnionFind unionFind = new UnionFind(n);
        int goodPaths =0;
        
        for(int value : valueToNodes.keySet()){
            
            for(int node : valueToNodes.get(value)){
                if(!adj.containsKey(node))
                        continue;
                for(int neighbor : adj.get(node)){
                    if(vals[node]>= vals[neighbor]){
                        unionFind.union(node,neighbor);
                    }
                }
            }
            Map<Integer,Integer> group = new HashMap<>();
            
            for(int node : valueToNodes.get(value)){
                group.put(unionFind.find(node),group.getOrDefault(unionFind.find(node),0)+1);
            }
            for(int key:group.keySet()){
                int size = group.get(key);
                goodPaths+=size*(size+1)/2;
            }
        }
        return goodPaths;
    }
}//T-O(nlogn),S-O(n)