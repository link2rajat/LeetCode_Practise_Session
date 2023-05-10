class Solution {
    public int[][] generateMatrix(int n) {
      int[][] result = new int[n][n];
        int count=1;
        for(int layer=0;layer<(n+1)/2;layer++){
            
            for(int ptr=layer;ptr<n-layer;ptr++){
             result[layer][ptr] = count++;   
            }
            
            for(int ptr=layer+1;ptr<n-layer;ptr++){
             result[ptr][n-layer-1] = count++;   
            }
            
            
            for(int ptr=layer+1;ptr<n-layer;ptr++){
             result[n-layer-1][n-ptr-1] = count++;   
            }
            
            for(int ptr=layer+1;ptr<n-layer-1;ptr++){
             result[n-ptr-1][layer] = count++;   
            }
        }
        return result;
    }
}//T-O(n^2),S-O(1)