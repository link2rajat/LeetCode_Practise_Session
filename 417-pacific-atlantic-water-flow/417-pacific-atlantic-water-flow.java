class Solution {
   private static final int[][] direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    private int numRows;
    private int numCols;
    private int [][] landHeights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==0 || heights[0].length==0)
        {
            return new ArrayList<>();
        }
        
        numRows=heights.length;
        numCols=heights[0].length;
        landHeights=heights;
        
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        for(int i=0;i<numRows;i++)
        {
            pacificQueue.offer(new int[]{i,0});
            atlanticQueue.offer(new int[]{i,numCols-1});
        }
        
        for(int j=0;j<numCols;j++)
        {
            pacificQueue.offer(new int[]{0,j});
            atlanticQueue.offer(new int[]{numRows-1,j});
        }
        
        boolean[][] pacificReachcells = bfs(pacificQueue);
        boolean[][] atlanticReachcells = bfs(atlanticQueue);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++)
            {
                if(pacificReachcells[i][j] && atlanticReachcells[i][j])
                {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }//T-O(m*n),S-O(m*n)
    
    boolean[][] bfs(Queue<int[]> queue)
    {
       boolean[][] reachable = new boolean[numRows][numCols];
        
        while(!queue.isEmpty())
        {
            int[] cell = queue.poll();
            
            reachable[cell[0]][cell[1]]= true;
            for(int[] dir: direction)
            {
                int newRow = cell[0]+dir[0];
                int newCol = cell[1]+dir[1];
                
                if(newRow<0 || newRow >= numRows || newCol<0 || newCol>= numCols)
                {
                    continue;
                }
                if(reachable[newRow][newCol])
                {
                    continue;
                }
                
                if(landHeights[newRow][newCol]<landHeights[cell[0]][cell[1]])
                {
                    continue;
                }
                queue.offer(new int[]{newRow,newCol});
            }
        }
        
        return reachable;
    }
}