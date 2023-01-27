class Solution {
   
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
         List<String> result = new ArrayList<>();
         HashSet<String> set = new HashSet<>();
        
        for(String word:words)set.add(word);
        
        for(String word:words)
        {
           boolean canConcat = isConcat(word,set,0);
            if(canConcat)
                result.add(word);
            
        }
        
        return result;
        
    }
    
    boolean isConcat(String word,HashSet<String> wordset, int count){
     if(count>0 && wordset.contains(word)) return true;
        boolean result =false;
        for(int i=1;i<word.length();i++)
        {
            String suffix = word.substring(0,i);
            if(wordset.contains(suffix))
            { 
                result = isConcat(word.substring(i), wordset, count+1);
                if(result) return result;
            }
        }
        
        return result;
        
    }
}