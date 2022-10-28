class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        if(strs.length==0) return new ArrayList();
        
        Map<String,List<String>> anagramMap = new HashMap<>();
        
        for(String currentString : strs)
        {
            char[] chArray = currentString.toCharArray();
            
            Arrays.sort(chArray);
            
            String key = String.valueOf(chArray);
            
            anagramMap.putIfAbsent(key,new ArrayList());
            
            anagramMap.get(key).add(currentString);
        }
        
        return new ArrayList(anagramMap.values());
    }
}//T-O(NKlogK),S-O(N)