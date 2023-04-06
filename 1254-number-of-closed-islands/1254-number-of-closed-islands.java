class Solution {
    
        
    public int closedIsland(int[][] grid) {
        
        int counter = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            if(grid[i][j]== 0 && !visited[i][j] && dfs(i,j,m,n,grid,visited)){
               counter++;
            }
          }
        }
        return counter;
    }//T-O(m*n),S-O(m*n)
    
    boolean dfs(int i,int j,int m,int n,int[][] grid,boolean[][] visited){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length )
            return false;
        
        if(grid[i][j]==1 || visited[i][j]){
            return true;
        }
        
        visited[i][j] = true;
        boolean isClosed = true;        
        int[] dirX ={0,1,0,-1};
        int[] dirY ={-1,0,1,0};
        
        for(int d=0;d<4;d++){
            int r = i+dirX[d];
            int c = j+dirY[d];
            if(!dfs(r,c,m,n,grid,visited)){
                isClosed = false;
            }
        }
   
        return isClosed;
        
    }
}