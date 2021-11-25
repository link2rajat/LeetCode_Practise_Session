class Solution {
    public String longestPalindrome(String s) {
       String result = new String();
        int maxlength=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
            String palindrom = parlindromicaroundCenter(i,i,s);
            
            if(palindrom.length()>maxlength)
            {
                maxlength=palindrom.length();
                result = palindrom;
            }

        
            String palindrom_even = parlindromicaroundCenter(i,i+1,s);
            
            if(palindrom_even.length()>maxlength)
            {
                maxlength=palindrom_even.length();
                result = palindrom_even;
            }

            
        }
        
        return result;
    }
    
    String parlindromicaroundCenter(int start, int end, String s)
    {
        while(start>=0 && end<s.length()&& s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        
        return s.substring(start+1,end);
        
        
    }
}
//t-O(n^2),s-O(1)