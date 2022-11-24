class Solution {
    public boolean exist(char[][] board, String word) {
    
        for(int row=0;row<board.length;row++)
        {
          for(int column=0;column<board[0].length;column++)
          {
              if(backtrack(board,row,column,word,0))
              {
                  return true;
              }
          }
        }

        return false;
    }
    // Time Complexity-O(N * (3^L)) where N is number of cells in board 
    // Space Complexity-O(L) where L is length of word 
    
    boolean backtrack(char[][] board,int currentRow,int currentColumn,String word,int index)
    {
        if(index>=word.length())
        {
            return true;
        }
        
        if(currentRow<0 || currentRow==board.length || currentColumn<0 || 
           currentColumn==board[0].length || board[currentRow][currentColumn]!= word.charAt(index))
        {
            return false;
        }
        
        board[currentRow][currentColumn] ='#';
        
        int[] rowOffsets = {0,1,0,-1};
        int[] colOffsets = {1,0,-1,0};
        
        for(int direction=0;direction<4;direction++)
        {
            int nextRow = currentRow + rowOffsets[direction];
            int nextColumn = currentColumn + colOffsets[direction];
            
            if(backtrack(board,nextRow,nextColumn,word,index+1))
            {
                return true;
            }
        }

        board[currentRow][currentColumn] =word.charAt(index);
       
        return false;
    }
    
}