class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return false;
        
        int rowLen=matrix.length-1,colLen=matrix[0].length-1;
        
        for(int i=0;i<=rowLen;i++)
        {
         for(int j=0;j<=colLen;j++)
         {
             if(i>0 && j>0 && matrix[i][j]!=matrix[i-1][j-1])
             {
                 return false;
             }
         }
        }
    
        return true;
    }
}//T-O(m*n),S-O(1)