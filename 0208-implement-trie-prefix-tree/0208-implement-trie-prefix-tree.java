class Trie {
class TrieNode{
    TrieNode[] t;
    int R=26;
    boolean isEnd;
    TrieNode(){
        t=new TrieNode[R];
    }
    void put(char ch,TrieNode node){
        t[ch-'a'] = node;
    }
    boolean containsKey(char ch){
        return t[ch-'a'] != null;
    }
   TrieNode  get(char ch){
       return t[ch-'a'];
   }
   boolean isEnd(){
      return isEnd; 
        }
   void setEnd(){
        isEnd=true;   
        }
}
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
       
        for(int i=0;i<word.length();i++){
          char wordChar = word.charAt(i);
            if(!node.containsKey(wordChar)){
                node.put(wordChar, new TrieNode());
            }
            node= node.get(wordChar);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node=searchPrefix(word);
        return node !=null && node.isEnd(); 
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node= searchPrefix(prefix); 
        return  node !=null;
    }
    
    
    TrieNode searchPrefix(String word){
       TrieNode node = root;
       for(int i=0;i<word.length();i++){
          char wordChar = word.charAt(i);
            if(node.containsKey(wordChar)){
            node= node.get(wordChar);
            }else{
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