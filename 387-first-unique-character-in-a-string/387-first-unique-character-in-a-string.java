class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> charFrequencyMap = new HashMap<>();
        
        for(int index=0; index<s.length();index++)
        {
           charFrequencyMap.put(s.charAt(index),charFrequencyMap.getOrDefault(s.charAt(index),0)+1); 
        }

        for(int index=0;index<s.length();index++)
        {
         if(charFrequencyMap.get(s.charAt(index))==1)
         {
             return index;
         }
        }    
        
        return-1;
    }
} //Time Complexity-O(n),Space Complexity-O(1) since 26 alphabets 