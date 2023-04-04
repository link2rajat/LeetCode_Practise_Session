class Solution {
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen,-1);
        int count=1,winStart=0;
        
        for(int winEnd=0;winEnd<s.length();winEnd++){
            
            if(lastSeen[s.charAt(winEnd)-'a']>=winStart){
                count++;
                winStart=winEnd;
            }
            lastSeen[s.charAt(winEnd)-'a']=winEnd;
        }
        return count;
    }
}//T-O(n(~26)),S-O(1)