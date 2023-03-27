class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        return traverse(grid,0,0,dp);
    }//T-O(m*n),S-O(m*n)
    
    public int traverse(int[][] grid,int row,int col,int [][] dp)
    {
        if(row== grid.length || col== grid[0].length)
        {
            return Integer.MAX_VALUE;
        }

      if(row== grid.length -1 && col== grid[0].length -1)
        {
            return grid[row][col];
        }
    if(dp[row][col]!=0)
    {
        return dp[row][col];
    }
    
        return dp[row][col] = Math.min(traverse(grid,row+1,col,dp) ,traverse(grid,row,col+1,dp)) + grid[row][col];

        
    }
}