class Solution {
    public int[] findBall(int[][] grid) {
      int[] ans = new int[grid[0].length];
        
        for(int i=0;i<grid[0].length;i++)
        {
            ans[i] = traverse(0,i,grid); 
        }
        
        return ans;
    }//T-(M*N),S-O(M*N)
    
    int traverse(int row,int col,int[][] grid)
    {
        
        if(row==grid.length)
            return col;
        int newCol=col+grid[row][col];
        if(newCol<0 || newCol>grid[0].length-1 || grid[row][col]!=grid[row][newCol])
        {
            return -1;
        }
        
        return traverse(row+1,newCol,grid);
    }
}