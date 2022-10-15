//https://leetcode.com/problems/string-compression-ii/discuss/757363/Java-Easy-and-fast-DP-solution-with-comments-50ms-Space-O(n2)
class Solution {
    public int getLengthOfOptimalCompression(String s, int K) {
        
        int n=s.length();
        
        int dp[][] = new int[n+1][K+1];
        
        for(int[] i: dp)
            Arrays.fill(i,n);
        
        dp[0][0]=0;
        
        for(int i=1;i<=n;i++)
        {
            for(int k=0;k<=K;k++)
            {
                if(k>0)
                dp[i][k] = Math.min(dp[i][k],dp[i-1][k-1]);
                

                int same=0,diff=0;
                for(int j=i;j>=1;j--)
                {
                    if(s.charAt(j-1) == s.charAt(i-1))same++;
                    
                    else diff++;
                    
                    if(diff>k)
                    break;
                    
                    dp[i][k]= Math.min(dp[i][k],dp[j-1][k-diff]+getLen(same));
                }
            }
        }
        
        return dp[n][K];
        
    }
    
    int getLen(int count)
    {
        if(count==1)return 1;
        else if(count<10)return 2;
        else if(count<100)return 3;
        else return 4;
    }
}