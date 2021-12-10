class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][]dp = new int[s.length()][s.length()];
       return findSubsequence(dp,0,s.length()-1,s);
    }
    
    int findSubsequence(int[][]dp,int start, int end, String s)
    {
        if(start>end)return 0;
        
        if(start==end)return 1;
        
        if(dp[start][end]!= 0)
        {
            return dp[start][end];
        }
        
        if(s.charAt(start)==s.charAt(end))
        {
            dp[start][end] = 2+findSubsequence(dp,start+1,end-1,s);
        }
        else{
            dp[start][end] = Math.max(findSubsequence(dp,start+1,end,s), findSubsequence(dp,start,end-1,s));
        }
        return  dp[start][end];
        
    }
}//T-O(N^2),S-O(N^2)