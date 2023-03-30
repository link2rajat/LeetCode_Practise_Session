class Solution {
    public boolean isScramble(String s1, String s2) {
       int n = s1.length();
       boolean dp[][][] = new boolean[n+1][n][n];
       
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               dp[1][i][j] = s1.charAt(i)==s2.charAt(j);
           }
       }
        
        for(int l =2;l<=n;l++){
         for(int i=0;i<n+1-l;i++){
           for(int j=0;j<n+1-l;j++){
             for(int newL=1;newL<l;newL++){
                 boolean dp1[] = dp[newL][i];
                 boolean dp2[] = dp[l-newL][i+newL]; 
                 dp[l][i][j] |= dp1[j] && dp2[j + newL];
                 dp[l][i][j] |= dp1[j+ l-newL] && dp2[j];
             }  
           }
         }
        }
        return dp[n][0][0];
    }
}//T-O(n^4),S-O(n^3)