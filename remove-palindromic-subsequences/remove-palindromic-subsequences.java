class Solution {
    public int removePalindromeSub(String s) {
        if(s.length()==0)return 0;
        if(isPalindrome(s))return 1;
        return 2;
    }
    
    
    boolean isPalindrome(String s)
    {
        int low=0;
        int high=s.length()-1;
   while(low<=high)
   {
        if(s.charAt(low)!=s.charAt(high))
        {
            return false;
        }
       low++;
       high--;
   }
        return true;
    }
    
}
//T-O(n),S-O(1)