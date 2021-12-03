class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDecimal = false;
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            
        if(Character.isDigit(ch))
        {
            seenDigit=true;
        }
        else if(ch=='+'||ch=='-')
        {
            if(i>0 && s.charAt(i-1) !='e' && s.charAt(i-1)!='E')
            {
                return false;
            }
        }
        else if(ch=='e'||ch=='E')
        {
            
            if(seenExponent || !seenDigit)
            {
                return false;
            }
            seenExponent=true;
            seenDigit=false;
        }
        else if(ch=='.')
        {
            if(seenExponent || seenDecimal)
            {
                return false;
            }
            seenDecimal=true;
        }
        else
        {
            return false;
        }    
        }
        return seenDigit;
    }
}//T-O(n),S-O(1)