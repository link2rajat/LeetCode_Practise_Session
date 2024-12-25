class Solution {
    public int lengthOfLongestSubstring(String s) {
        int winStart=0;
        int maxLength=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int winEnd=0;winEnd<s.length();winEnd++){
            if(map.containsKey(s.charAt(winEnd))){
                winStart=Math.max(winStart,map.get(s.charAt(winEnd)));
            }
            map.put(s.charAt(winEnd),winEnd+1);
            maxLength=Math.max(maxLength,winEnd-winStart+1);
        }
        return maxLength;
        
    }
}