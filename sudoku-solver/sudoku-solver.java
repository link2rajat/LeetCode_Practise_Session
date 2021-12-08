class Solution {
    public void solveSudoku(char[][] board) {
     
        if(board==null || board.length==0)
        {
            return;
        }
        sudokuSolver(board);
    }
    
    boolean sudokuSolver(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char ch='1';ch<='9';ch++)
                    {
                        if(isValid(board,i,j,ch))
                        {
                         
                        board[i][j]=ch;
                         
                        if(sudokuSolver(board))
                            return true;
                        else
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    
    boolean isValid(char[][] board,int row,int col,char num)
    {
        int rowRegion = 3* (row/3);
        int colRegion = 3* (col/3);
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==num) return false;
            if(board[i][col]==num) return false;
            if(board[rowRegion+i/3][colRegion+i%3]==num)return false;
        }
        return true;
        
    }
}
//T-O(9^N),S-(9^N)