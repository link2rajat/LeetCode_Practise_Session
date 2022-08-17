class Solution {
    public int uniqueMorseRepresentations(String[] words) {
      
        String[] Morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> seen = new HashSet();
        
        for(String word:words)
        {
            StringBuilder currentWordCode = new StringBuilder();
            for(char ch:word.toCharArray())
            {
                currentWordCode.append(Morse[ch-'a']);
            }
            seen.add(currentWordCode.toString());
        }
        return seen.size();
    }
}//T-O(N),S-O(N) where N is sum of length of words in words