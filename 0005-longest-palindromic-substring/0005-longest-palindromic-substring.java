class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
       //  if (n<=1)return s;
        
        boolean[][] dp = new boolean[n][n];
        
        int palinStart=0;
        int maxLen=1;
        
       //Trivial case: single letter palindromes  
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
            
        }
       
        //Finding palindromes of two characters
        for(int i=0;i<n-1;i++)
        {
         if(s.charAt(i)==s.charAt(i+1)) 
          {
            dp[i][i+1]=true;
             palinStart=i;
             maxLen=2;
          }
        }
        //Finding palindromes of length 3 to n and saving the longest
        for(int curr_len=3;curr_len<=n;curr_len++)
        {
          for(int i=0;i<n-curr_len+1;i++) 
          {
              int j=i+curr_len-1;
              if(s.charAt(i)==s.charAt(j) //First and last characters should match 
                 && dp[i+1][j-1]) //Rest of the substring should be a palindrome
              {
              dp[i][j]=true;
                palinStart=i;
                maxLen=curr_len ; 
              }
          }
            
        }
 return s.substring(palinStart,palinStart+maxLen);
 
    }
}//T-O(n^2),S-O(n^2)