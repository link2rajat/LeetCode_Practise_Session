//https://leetcode.com/problems/break-a-palindrome/discuss/489774/JavaC%2B%2BPython-Easy-and-Concise
class Solution {
    public String breakPalindrome(String palindrome) {
        char[] chArr = palindrome.toCharArray();
        int n = palindrome.length();
        
        for(int i=0;i<n/2;i++)
        {
            if(chArr[i]!='a')
            {
               chArr[i]='a';
               return String.valueOf(chArr);
            }
        }
        chArr[n-1]='b'; //if all a in the string
        return n<2?"":String.valueOf(chArr);
    }
}//T-O(n),S-O(n)