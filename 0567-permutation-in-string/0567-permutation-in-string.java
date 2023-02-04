class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> pattern = new HashMap<>();
        
        
        for(char ch: s1.toCharArray())
        {
            pattern.put(ch,pattern.getOrDefault(ch,0)+1);
        }
        int match=0;
        int winstart=0;
        
        for(int winEnd=0;winEnd<s2.length();winEnd++)
        {
            if(pattern.containsKey(s2.charAt(winEnd)))
            {
                
                pattern.put(s2.charAt(winEnd),pattern.get(s2.charAt(winEnd))-1);
                if(pattern.get(s2.charAt(winEnd))==0)
                match++;
            }
            
            if(match==pattern.size())
            {
                return true;
            }
            
            if(winEnd>=s1.length()-1)
            {
                char ch = s2.charAt(winstart) ;
                
            if(pattern.containsKey(ch))
            {
                if(pattern.get(ch)==0)
                match--;
               
                pattern.put(ch,pattern.get(ch)+1);
            }
                   winstart++; 
            }
            
        }
        return false;
    }
}//T-O(m+n),S-O(m) where  m is length of s1 and n is length of s2