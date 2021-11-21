

  class TrieNode{
      
      TrieNode[] node;
          
      public final int R =26;
      
      public boolean isEnd;
      
     public TrieNode()
      {
          node= new TrieNode[R];
      }
      
     public boolean containKey(char ch)
      {
          return node[ch-'a'] !=null;
      }
      
     public TrieNode get(char ch)
      {
          return node[ch-'a'];
      }
      
     public void put(char ch,TrieNode element)
      {
           node[ch-'a'] = element;
      }
      
     public boolean isEnd()
      {
          return isEnd;
      }

    public void setIsEnd()
      {
         isEnd=true;
      }
  }
    
    /** Initialize your data structure here. */

class Trie {
    
    TrieNode root;
        
    public Trie(){
            root = new TrieNode();
        }
    
    //T-O(n),S-O(n) n is the key length
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        TrieNode node = root;
        
        for(int i=0;i<word.length();i++)
        {
         if(!node.containKey(word.charAt(i)))
            {
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
            node.setIsEnd();            
    }
    //T-O(n),S-O(1) n is the key length
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
       TrieNode node = searchwithinTrieHeirarchy(word);  
        return  node != null && node.isEnd();
    }
    //T-O(n),S-O(1) n is the key length
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       TrieNode node = searchwithinTrieHeirarchy(prefix);  
        return node != null;
    }
            
            
    TrieNode searchwithinTrieHeirarchy(String word)
    { 
        TrieNode node =root;
       for(int i=0;i<word.length();i++)
        {
            if(node.containKey(word.charAt(i)))
            {
            node = node.get(word.charAt(i));
            }
            else
               {
                   return null;
               }
        }
     return node;
    }
}
        

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */