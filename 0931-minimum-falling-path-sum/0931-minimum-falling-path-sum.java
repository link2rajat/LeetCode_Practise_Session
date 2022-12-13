class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        int minFallingPathSum = Integer.MAX_VALUE;
        
        Integer[][] memo = new Integer[rowLen][colLen];
        
        for(int j=0;j<colLen;j++){
            minFallingPathSum = Math.min(minFallingPathSum,surroundingDfsSum(matrix,0,j,memo));
        }
        return minFallingPathSum;         
    }//T-O(n^2),S-O(n^2)
    
    int surroundingDfsSum(int[][] matrix,int row, int col,Integer[][] memo){
        
        if(col<0 || col == matrix.length){
            return Integer.MAX_VALUE;
        }
        
        if(row==matrix.length-1){
            return matrix[row][col];
        }
        if(memo[row][col] != null){
            return memo[row][col];
        }
        
        int left = surroundingDfsSum(matrix,row+1,col,memo);
        int right = surroundingDfsSum(matrix,row+1,col-1,memo);
        int middle = surroundingDfsSum(matrix,row+1,col+1,memo);
        
        memo[row][col] = Math.min(left,Math.min(middle,right))+matrix[row][col];
        
        return memo[row][col];
    }
    
}