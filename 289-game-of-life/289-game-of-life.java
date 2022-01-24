
class Solution {
    final static int[][] direction = {{0,-1},{1,0},{0,1},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
    
        if(board==null || board.length==0) 
            return;
        for(int row=0;row<board.length;row++)
        {
         for(int column=0;column<board[0].length;column++)
         {

          if(board[row][column]== 0)
          {
           int lives = countLives(board,row,column); 
           if(lives ==3)
           {
             board[row][column] =-1;  
           }
          }
              
          if(board[row][column] == 1) 
          {
           int lives = countLives(board,row,column); 
              if(lives<2 || lives>3)
              {
                  board[row][column] =2;  
              }
          }
         }
        }
        
        updateBoard(board);
    }//Time Complexity = O(m*n),Space Complexity = O(1)
    
    int countLives(int[][] board, int currentRow, int currentColumn)
    {
        int currentLive=0;
        for(int[] dir: direction)
        {
            int newRow = currentRow + dir[0];
            int newColumn = currentColumn + dir[1];
            
            if(newRow>=0 && newRow<board.length && newColumn>=0 && newColumn<board[0].length 
               && (board[newRow][newColumn]==1 || board[newRow][newColumn]==2))
            {
                currentLive++;
            }
        }
        
        return currentLive;
    }
    
    void updateBoard(int[][] board)
    {
         for(int row=0;row<board.length;row++)
         {
          for(int column=0;column<board[0].length;column++)
           {
             if(board[row][column]== -1)
             {
                 board[row][column]=1;
             }
             
             if(board[row][column]== 2)
             {
                 board[row][column]=0;
             }
           }
         }
    }
    
}