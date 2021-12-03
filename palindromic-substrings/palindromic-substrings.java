class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0)
        {
            return 0;
        }
       
        int ans=0;
        
        for(int index=0;index<s.length();index++)
        {
          ans+=palindromicAroundCenter(index,index,s);

          ans+=palindromicAroundCenter(index,index+1,s);

        }
        
        return ans;
    }
    
    int palindromicAroundCenter(int left,int right,String s)
    {
        int count=0;
        while(left>=0 && right <s.length() && s.charAt(left)==s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
    }
    
    
}//T-O(n),S-O(1)