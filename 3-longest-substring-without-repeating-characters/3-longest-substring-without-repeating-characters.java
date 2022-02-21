class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        int winStart=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int winEnd=0;winEnd<s.length();winEnd++)
        {
            
            if(map.containsKey(s.charAt(winEnd)))
            {
                
              winStart = Math.max(map.get(s.charAt(winEnd)),winStart);
            }
            map.put(s.charAt(winEnd),winEnd+1);
            
            length= Math.max(length,winEnd-winStart+1);
        }
        return length;
    }
}//T-O(N),S-O(K) where K is distinct character in map