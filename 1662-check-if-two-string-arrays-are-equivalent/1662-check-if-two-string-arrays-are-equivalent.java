class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
      String s1 = concat(word1);
      String s2 = concat(word2);
        
        return s1.compareTo(s2)==0;
    }
    
    String concat (String[] words)
    {
     StringBuilder sb = new StringBuilder();
        
        for(String s:words)
        {
            sb.append(s);
        }
        return sb.toString();
    }
}//T-O(m*n),S-O(m*n)