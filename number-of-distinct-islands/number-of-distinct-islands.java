class Solution {
    int[][] grid;
    boolean[][] seen;
    ArrayList<Integer> shape;
    
    public int numDistinctIslands(int[][] grid) {
     this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<ArrayList<Integer>>();
        
        for(int r=0;r< grid.length;r++)
        {
            for(int c=0;c<grid[0].length;c++){
                shape = new ArrayList<Integer>();
                int currentValue = grid[r][c];
                explore(r,c,0);
                if(!shape.isEmpty())
                {
                    shapes.add(shape);
                }
            }
        }
        
        return shapes.size();
    }
    
    public void explore(int r, int c, int direction)
    {
       
        if(r>=0 && r< grid.length && c>=0 && c< grid[0].length && grid[r][c]==1 && !seen[r][c])
        {
            seen[r][c] = true;
            shape.add(direction);
            explore(r+1,c,1);
            explore(r-1,c,2);
            explore(r,c+1,3);
            explore(r,c-1,4);
            shape.add(0);
        }
    }
}