class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character>  mapST = new HashMap<>();
        HashMap<Character,Character>  mapTS = new HashMap<>();
        
        int i=0,j=0;
        
        while(i<s.length() && j<t.length()){
            if((mapST.containsKey(s.charAt(i)) && mapST.get(s.charAt(i)) != t.charAt(j))
               ||(mapTS.containsKey(t.charAt(j)) && mapTS.get(t.charAt(j)) != s.charAt(i))){
                return false;
            }
            mapST.put(s.charAt(i),t.charAt(j));
            mapTS.put(t.charAt(j),s.charAt(i));
            i++;
            j++;
        }
        return true;
    }
}