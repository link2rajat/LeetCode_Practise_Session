//https://www.youtube.com/watch?v=zWS2fCJGxmU&ab_channel=codebix
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int counts=0;
        boolean [][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[n-1][0]=true;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
           
            for(int i=0;i<size;i++)
            {
                int x = queue.poll();
                if(x==n*n)
                {return counts;}
                for(int k=1;k<=6;k++)
                {
                    if(k+x>n*n)break;
                    int[] nextPos = newBoardIndexes(k+x,n);
                    int newRowIdx = nextPos[0];
                    int newColIdx = nextPos[1];
                    if(visited[newRowIdx][newColIdx]==true)continue;
                    visited[newRowIdx][newColIdx]=true;
                    if(board[newRowIdx][newColIdx]==-1)
                    {
                     queue.offer(k+x);
                    }
                    else
                    {
                      queue.offer(board[newRowIdx][newColIdx]);  
                    }
                }
            }
             counts++;
        }
        return -1;
    }
    int[] newBoardIndexes(int current, int n)
    {
        int row = n-(current-1)/n -1;
        int col = (current-1)%n;
        if(row%2==n%2)//number of rows and size are even then board indexes is rhs to lhs else lhs to rhs
        {
            return new int[]{row,n-col-1};
        }
        else
        {
            return new int[]{row,col};
        }
            
    }
}