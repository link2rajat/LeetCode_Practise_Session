class Solution {
    public int characterReplacement(String s, int k) {
          
        int windowStart=0;
        int max_occurance=0;
        int max_Window_size=0;
        Map<Character,Integer> charFreqMap = new HashMap<>();
        
        for(int windowEnd=0; windowEnd<s.length();windowEnd++)
        {
            char right_char =s.charAt(windowEnd);
            charFreqMap.put(right_char,charFreqMap.getOrDefault(right_char,0)+1);
            max_occurance = Math.max(max_occurance,charFreqMap.get(right_char));
            
            if(windowEnd-windowStart+1-max_occurance>k)
            {
            char left_char =s.charAt(windowStart);
            charFreqMap.put(left_char,charFreqMap.getOrDefault(left_char,0)-1);
            windowStart++;
            }
            max_Window_size= Math.max(max_Window_size,windowEnd-windowStart+1);
                
        }
        return max_Window_size;
    }
} // T-O(n),S-O(1)