/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {
    
    class TrieNode{
        
    TrieNode[] links; 
    boolean isEnd;
     final int size =26;   
        
        TrieNode()
        {
            links = new TrieNode[size];
        }
        
        void put(char ch,TrieNode node)
        {
            links[ch-'a'] = node;
        }
        
        boolean containsKey(char ch)
        {
          return links[ch-'a']!=null;
        }
        
        TrieNode  get(char ch)
        {
          return  links[ch-'a'];
        }

        void setEnd()
        {
            isEnd = true;
        }
        
        boolean isEnd()
        {
            return isEnd;
        }
    
    }
    
   TrieNode root ; 
 
    public Trie() {
        root = new TrieNode();
    }
    //T-O(m),S-O(m)
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new TrieNode());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }
    //T-O(m),S-O(1)
    public boolean search(String word) {
        TrieNode node =searchInTrie(word);
        return  node!=null && node.isEnd();
    }
    //T-O(m),S-O(m)
    public boolean startsWith(String prefix) {
        TrieNode node =searchInTrie(prefix);
        return  node!=null;        
    }
    
    public TrieNode searchInTrie(String word)
    { 
        TrieNode node = root;
        for(int i=0;i<word.length();i++)
        {
            if(node.containsKey(word.charAt(i)))
            {
            node=node.get(word.charAt(i));
            }
            else
            {
            return null;
            }
        }
     return node;
    }
}
