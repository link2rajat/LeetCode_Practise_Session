class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()*k==0)
            return 0;
        int max=0;
        int winStart=0;
        Map<Character,Integer>map =new HashMap<>();
        
        for(int winEnd=0;winEnd<s.length();winEnd++)
        {
            map.put(s.charAt(winEnd),map.getOrDefault(s.charAt(winEnd),0)+1);
            
            while(map.size()>k)
            {
            map.put(s.charAt(winStart),map.get(s.charAt(winStart))-1);
            if(map.get(s.charAt(winStart))==0)
            {
            map.remove(s.charAt(winStart));
            }
            winStart++;
            }
            max=Math.max(max,winEnd-winStart+1);
        }
        
        return max;
    }
}//T-O(n),S-O(1)