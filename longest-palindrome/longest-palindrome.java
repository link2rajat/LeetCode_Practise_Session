class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result=0; 
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            if(map.get(s.charAt(i))%2==0)
            {
                result++;
            }
        }
        
        return Math.min(s.length(),2*result+1);
    }
}//T-O(n),S-O(n)