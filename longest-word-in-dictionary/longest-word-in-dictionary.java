class Solution {
    
  
    
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> wordSet = new HashSet<String>();
        String result = new String();
        
        for(String word: words)
        {
            if(word.length()==1 || wordSet.contains(word.substring(0,word.length()-1)))
            {
                result = word.length()> result.length() ? word: result;
                wordSet.add(word);
            }
            
        }
        return result;
    }
}//T-O(n^2),S-O(n)