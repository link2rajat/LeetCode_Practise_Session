class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rowLen = maze.length , colLen = maze[0].length;
        int [][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        int startRow = entrance[0] , startCol = entrance[1];
        maze[startRow][startCol] ='+';
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow,startCol,0});
        
        while(!queue.isEmpty()){
            int[] currentState = queue.poll();
            
            int currRow = currentState[0], currCol = currentState[1], currentDist = currentState[2];
            
            
            for(int[] dir : directions)
            {
                
                int nextRow = currRow + dir[0] , nextCol = currCol + dir[1];
                
                if(nextRow>=0 && nextRow < rowLen && nextCol >=0 && nextCol< colLen && maze[nextRow][nextCol]=='.'){
                   if(nextRow == 0 || nextRow == rowLen-1 || nextCol == 0 || nextCol == colLen-1)
                   {
                       return currentDist+1;
                   }
                   
                    maze[nextRow][nextCol] ='+';
                    queue.offer(new int[]{nextRow,nextCol,currentDist+1});
                }
            }
        }
        
        return -1;
    } //T-O(m*n),S-O(max(m,n))
}