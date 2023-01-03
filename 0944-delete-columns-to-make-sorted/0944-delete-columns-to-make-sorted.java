class Solution {
    public int minDeletionSize(String[] strs) {
        int deleteCount =0;
        int n = strs[0].length();
  
        for(int col=0;col<n;col++){
            for(int row=1;row<strs.length;row++)
                {
                if(strs[row].charAt(col)<strs[row-1].charAt(col)){
                deleteCount++; 
                break;
                }
            }
         }   
        return deleteCount;
    }
}//T-O(n*k),S-O(1)