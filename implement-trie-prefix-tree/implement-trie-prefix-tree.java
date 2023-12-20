class TrieNode{
    TrieNode[] links;
    final int R = 26;
    boolean isEnd;
    
    TrieNode(){
       links  = new TrieNode[R]; 
    }
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,TrieNode node){
        links[ch-'a']=node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node =root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = searchWithPrefix(word);
        return node !=null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchWithPrefix(prefix);
        return node !=null ;
    }
    private TrieNode searchWithPrefix(String word){
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
            node=node.get(ch);
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