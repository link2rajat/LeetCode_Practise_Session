class Solution {
      int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        
        int rowLen= grid.length;
        int colLen=grid[0].length;
        if(grid==null|| grid.length==0)
            return 0;
      
        boolean[][][] visited = new boolean[rowLen][colLen][k+1];
        visited [0][0][0]=true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});  
        int count=0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
            int[] node = queue.poll();  
            
            int currentRow = node[0];
            int currentCol = node[1];
            int currentK = node[2];
            
            if(currentRow==rowLen-1 && currentCol==colLen-1)
            {
                return count;
            }
                
           for(int[] dir: direction)
           {
               
               int newRow = currentRow + dir[0];
               int newCol = currentCol + dir[1];
               int newK=currentK;
               if(newRow<rowLen && newRow>=0 && newCol<colLen && newCol>=0 )
               {
                   if(grid[newRow][newCol]==1)
                   {
                       newK++;
                   }
                   if(newK<=k && !visited[newRow][newCol][newK])
                   {
                   visited[newRow][newCol][newK] =true;
                   queue.add(new int[]{newRow,newCol,newK});
                       
                   }
               }
         
           }
        }
            count++;
        }
        
        return -1;
    }
}//T-O(MNK),S-O(MNK) where m is lenght of row and n is length of col, and k is number of obstrecles