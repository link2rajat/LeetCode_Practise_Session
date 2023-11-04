class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int winStart=0;
        int maxLength=0;
        for(int winEnd=0;winEnd<s.length();winEnd++){

            if(map.containsKey(s.charAt(winEnd))){
                winStart= Math.max(map.get(s.charAt(winEnd)),winStart);
            }
            
            map.put(s.charAt(winEnd),winEnd+1);
            maxLength=Math.max(maxLength,winEnd-winStart+1);
        }
        return maxLength;
    }
}