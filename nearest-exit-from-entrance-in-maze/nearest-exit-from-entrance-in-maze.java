class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows=maze.length,cols=maze[0].length;
        
        int[][] direction = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        
        int startRow = entrance[0],startColumn=entrance[1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow,startColumn,0});
        maze[startRow][startColumn]='+';
        
        while(!queue.isEmpty()){
            int[] currentSpot = queue.poll();
            int row = currentSpot[0],col = currentSpot[1],distance= currentSpot[2];
            for(int[] dir:direction){
                int newRow=row+dir[0],newCol=col+dir[1];
                if(0<=newRow &&  newRow<rows && 0<=newCol && newCol<cols  && maze[newRow][newCol]=='.'){
                    
                    if(newRow==0 ||newRow==rows-1 || newCol==0 || newCol==cols-1)
                        return distance+1;
                    
                    maze[newRow][newCol]='+';
                    queue.offer(new int[]{newRow,newCol,distance+1});
                }
            }
        }
        return -1;
    }
}