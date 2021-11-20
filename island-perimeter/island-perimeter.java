class Solution {
    public int islandPerimeter(int[][] grid) {
        int result=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    result+=getConnected(i,j,grid);
                }
                
            }
        }
        
        return result;
    }
    
    int getConnected(int i,int j,int grid[][])
    {
        int sum=0;
        //UP
        if(i==0 || grid[i-1][j]==0)sum++;
        //LEFT
        if(j==0 || grid[i][j-1]==0)sum++;
        //DOWN
        if(i==grid.length-1 || grid[i+1][j]==0)sum++;
        //RIGHT
        if(j==grid[0].length-1 || grid[i][j+1]==0)sum++;
        
        return sum;
    }
}//T-O(MN),S-O(1)