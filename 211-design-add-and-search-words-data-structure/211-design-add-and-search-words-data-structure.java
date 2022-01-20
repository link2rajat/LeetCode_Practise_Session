class TrieNode {
        Map<Character,TrieNode> map = new HashMap<>();
        boolean word = false;
        public TrieNode() { } 
    }
class WordDictionary {
    
    TrieNode trie;
    
    public WordDictionary() {
        trie = new  TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        
        for(char ch:word.toCharArray())
        {
            if(!node.map.containsKey(ch))
            {
                node.map.put(ch, new TrieNode());
            }
            node = node.map.get(ch);
        }
        node.word=true;
    }//T-O(k),S-O(k) where k is key length
    
    public boolean search(String word) {
        return searchInNode(word,trie);
    }
    
    boolean searchInNode(String word,TrieNode node)
    {
        for(int i=0;i<word.length();i++)
        {
         char ch = word.charAt(i);
         
         if(!node.map.containsKey(ch))
         {
           if(ch=='.')
           {
             for(char xy: node.map.keySet())
               {
                 TrieNode child = node.map.get(xy);
                 if(searchInNode(word.substring(i+1),child)) 
                 {
                    return true;
                 }
               }
           }
            return false;
         } else {
             node = node.map.get(ch);
         }
        }
       return node.word;    
    }
}//T-O(M),S-O(1)

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */