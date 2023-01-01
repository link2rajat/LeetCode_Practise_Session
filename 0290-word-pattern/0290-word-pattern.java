class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap indexMap = new HashMap();
        String[] words = s.split(" ");
        
        if(words.length != pattern.length())
            return false;
        
        for(Integer i=0;i<words.length;i++){
            char c = pattern.charAt(i);
            String word = words[i];
            
            if(!indexMap.containsKey(c)){
                indexMap.put(c,i);
            }
            
            if(!indexMap.containsKey(word)){
                indexMap.put(word,i);
            }
            
            if(indexMap.get(c) != indexMap.get(word)){
                return false;
            }
        }
        
        return true;
    }
}//T-O(N),O-(M)