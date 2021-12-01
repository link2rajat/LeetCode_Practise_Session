class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
     List<Integer> result = new ArrayList<>();
        
        if (matrix.length==0|| matrix[0].length==0)
            return result;
        
        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;
        
           while(rowBegin<=rowEnd && colBegin<=colEnd)
           {
                   for(int j=colBegin;j<=colEnd;j++)
                   {
                     result.add(matrix[rowBegin][j]);
                   }
                 rowBegin++;
  
                   for(int i=rowBegin;i<=rowEnd;i++)
                   {
                     result.add(matrix[i][colEnd]);
                   }
                 colEnd--;
 
               
                
               if(rowBegin<=rowEnd)
               {
                   for(int j=colEnd;j>=colBegin;j--)
                   {
                     result.add(matrix[rowEnd][j]);
                   }
               }
               rowEnd--;
               
               if(colBegin<=colEnd)
               {
                   for(int i=rowEnd;i>=rowBegin;i--)
                   {
                     result.add(matrix[i][colBegin]);
                   }
               }
             colBegin++;
            
               
           }
        
        return result;
 
    }
}//T-O(MN),S-O(1)