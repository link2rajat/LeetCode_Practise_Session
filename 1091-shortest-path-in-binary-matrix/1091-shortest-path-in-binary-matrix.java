//https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/359287/Java-BFS-20-ms-faster-than-73.32-48.7-MB-less-than-100.00,2.) https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/312706/JAVA-BFS, 3.)https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/430817/Java-Simple-BFS-without-level-order,4.) https://towardsdatascience.com/graph-theory-bfs-shortest-path-problem-on-a-grid-1437d5cb4023
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid==null || grid.length==0|| grid[0].length==0 || grid[0][0]==1)
        {
            return -1;
        }
        
        int rows = grid.length;
        int columns = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        int distance = 0;
        
        while(!queue.isEmpty())
        { 
            int size = queue.size();
         
            for(int i=0;i<size;i++)
            {
                int[] node = queue.poll();
                if(node[0]== rows-1 && node[1]== columns-1)
                { 
                    return distance+1;
                }
                for(int rowinc=-1;rowinc<=1;++rowinc)
                {
                    for(int colinc=-1;colinc<=1;++colinc)
                    {
                        if(rowinc==0 && colinc==0)
                        {
                            continue;
                        }
                        
                        int newRow =node[0]+rowinc;
                        int newCol = node[1]+colinc;
                        if(newRow >=0 && newRow< rows && newCol>=0 && newCol< columns && !visited[newRow][newCol] && grid[newRow][newCol]==0)
                        {
                            queue.offer(new int[]{newRow,newCol});
                            visited[newRow][newCol]=true;
                            
                        }
                    }
                }
                
            }
            distance++;
            
        }
        
        return -1;
        
    }
}