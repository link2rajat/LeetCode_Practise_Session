class Solution {
    public int snakesAndLadders(int[][] board) {
        int boardSize=board.length;
        int counts=0;
        boolean[][] visited= new boolean[boardSize][boardSize];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[boardSize-1][0]=true;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                int current = queue.poll();
                if(current==boardSize*boardSize)
                    return counts;
                
                for(int dice=1;dice<=6;dice++){
                    
                    if(dice+current>boardSize*boardSize)
                        break;
                    
                    int[] nextPos = nextBoardIndexes(dice+current,boardSize);
                    int nextRow =  nextPos[0];
                    int nextCol =  nextPos[1];
                    if(visited[nextRow][nextCol]==true)
                        continue;
                    visited[nextRow][nextCol]=true;
                    
                    if(board[nextRow][nextCol]==-1){
                        queue.offer(dice+current);
                    }else{
                        queue.offer(board[nextRow][nextCol]);
                    }
                   
                }
            }
            counts++;
        }
        return -1;
        
    }
    int[] nextBoardIndexes(int current,int boardSize) {
        int row = boardSize-(current-1)/boardSize-1;
        int col = (current-1)%boardSize;
        ///number of rows and size are even then board indexes is rhs to lhs else lhs to rhs
        if(row%2==boardSize%2){
            return new int[]{row,boardSize-col-1};
        }else{
            return new int[]{row,col}; 
        }
    }
}