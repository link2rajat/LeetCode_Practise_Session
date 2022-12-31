class Solution {
    int rows,cols;
    int[][] grid;
    int pathCount;
    
    public int uniquePathsIII(int[][] grid) {
     int nonObstracles =0, startRow =0,startCol =0;
        
        this.rows = grid.length;
        this.cols = grid[0].length;
        for(int row=0;row< grid.length;++row){
            for(int col=0;col<grid[0].length;++col){
                int currentCell = grid[row][col];
                if(currentCell>=0){
                    nonObstracles++;
                } 
                if(currentCell==1){
                    startRow = row;
                    startCol = col;
                }
            }
        }
        
        this.pathCount=0;
        this.grid = grid;
        
        backtrack(startRow,startCol,nonObstracles);
        
        return this.pathCount;
    }//T-O(3^N),S-O(N)
    
    protected void backtrack(int row, int col,int remain){
        if(this.grid[row][col] == 2 && remain == 1){
            this.pathCount+=1;
            return;
        }
        int temp = grid[row][col];
        grid[row][col] = -4;
        remain-=1;
        
        int[] rowOffSet ={0,0,1,-1};
        int[] colOffSet ={1,-1,0,0};
        
        for(int i=0;i<4;++i){
            int nextRow = row + rowOffSet[i];
            int nextCol = col + colOffSet[i];
            
            if(nextRow<0 || nextRow>=this.rows || nextCol<0 || nextCol>=this.cols)
                continue;
            
            if(grid[nextRow][nextCol]<0)
                continue;
            
            backtrack(nextRow,nextCol,remain);
        }
         grid[row][col] = temp;
    }
}