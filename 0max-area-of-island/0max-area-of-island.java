class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxArea=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxArea = Math.max(maxArea,dfs(i,j,grid,visited));
            }
        }
        return maxArea;
    }
    
    int dfs(int r,int c,int[][] grid,boolean[][] visited){
        if(r<0 ||r>=grid.length|| c<0 || c>=grid[0].length ||  visited[r][c]|| grid[r][c]==0)
            return 0;
        visited[r][c]=true;
        return 1+dfs(r+1,c,grid,visited)+dfs(r-1,c,grid,visited)
            +dfs(r,c+1,grid,visited)+dfs(r,c-1,grid,visited);
    }
}