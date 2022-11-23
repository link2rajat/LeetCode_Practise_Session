class Solution {
    public boolean isValidSudoku(char[][] board) 

    {
         if(board == null || board.length !=9 || board[0].length !=9) 
         {
        return false;
    }
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> colMap = new HashMap<>();
        Map<Integer,Set<Character>> boxMap = new HashMap<>();
        
        for(int i=0;i<board.length;i++)
        {
             for(int j=0;j<board[0].length;j++)
             {
                 if(board[i][j] == '.')
                     continue;
                 
                  int box = (i/3)*3 + (j/3);
                 
                 if( validateSudoku(rowMap,board[i][j],i)|| validateSudoku(colMap,board[i][j],j)|| validateSudoku(boxMap,board[i][j],box))
                 {
                     return false;
                 }
             }
        }
        return true;
    }
    
  public boolean validateSudoku( Map<Integer,Set<Character>> validateMap ,Character boardChar,Integer index)
    {
        if(validateMap == null || boardChar == null)
        {
            return false;
        }
      validateMap.computeIfAbsent(index,idx->new HashSet<Character>());
      
      if(validateMap.get(index).contains(boardChar))
      {
          return true;
      }
      else{
       validateMap.get(index).add(boardChar);   
      }
    return false;
      
    }
    
}