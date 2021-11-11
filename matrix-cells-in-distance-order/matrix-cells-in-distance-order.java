//4 direction dfs 

class Solution {

    static   int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
     
        int[][] result = new int[rows*cols][2];
        int res_index=0;
        boolean[][] visited = new boolean[rows][cols];
        
        Queue<int[]> bfsqueue = new LinkedList<>();
        
          bfsqueue.add(new int[]{rCenter,cCenter});
              
              visited[rCenter][cCenter] = true;
            
              while(!bfsqueue.isEmpty())
              {
                  int [] current = bfsqueue.poll();
                  result[res_index++] = current;
                  

                  for(int[] dir: direction)
                  {
                      int new_x= current[0]+dir[0];
                      int new_y= current[1]+dir[1];

                      if( new_x<0 || new_x>=rows || new_y<0 || new_y>=cols || visited[new_x][new_y])
                      {
                          continue;
                      }
                     
                      visited[new_x][new_y]=true;
                      bfsqueue.add(new int[]{new_x,new_y});
                      
                  }
                  
              }
        
        return result;
    }
}//T-O(r*c),S-O(r*c) where r is total # of rows and c is total # of cols