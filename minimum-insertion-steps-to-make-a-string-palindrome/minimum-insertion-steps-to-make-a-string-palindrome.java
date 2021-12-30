class Solution {
    public int minInsertions(String s) {
        if(isPlaindrome(s))
        {
            return 0;
        }
        
       
        return s.length()- lps(s);
        
    }
    
    int lps(String s)
    {
        Integer[][] dp = new Integer[s.length()][s.length()];
        
        return lpsrecurse(dp,s,0,s.length()-1);
    }
    
    int lpsrecurse(Integer[][] dp,String s,int startIdx,int endIdx)
    {
        if(startIdx>endIdx)
        {
            return 0;
        }

        if(startIdx==endIdx)
        {
            return 1;
        }
        
        if(dp[startIdx][endIdx]== null)
        {
            if(s.charAt(startIdx)==s.charAt(endIdx))
            {
                dp[startIdx][endIdx]= 2+ lpsrecurse(dp,s,startIdx+1,endIdx-1);
            }
            
            else
            {
                int count1 = lpsrecurse(dp,s,startIdx+1,endIdx);
                int count2 = lpsrecurse(dp,s,startIdx,endIdx-1);
                dp[startIdx][endIdx] = Math.max(count1,count2);
            }

        }
        return dp[startIdx][endIdx];
    }
    boolean isPlaindrome(String s)
    {
        
        int low=0,high=s.length()-1;
        
        while(low<=high)
        {
            
            if(s.charAt(low)!= s.charAt(high))
            {
                return false;
            }
            
            low++;
            high--;
        }
        
        return true;
    }
}//T-O(N^2),S-O(N^2)