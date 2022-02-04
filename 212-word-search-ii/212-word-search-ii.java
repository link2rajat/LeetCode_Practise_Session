class TrieNode
{
    HashMap<Character,TrieNode> children = new HashMap<>();
    String word= null;
    public TrieNode(){}
}
    
class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
       
    ArrayList<String> result = new ArrayList<>();
    TrieNode root= new TrieNode();
        
    for(String word: words)
    {
        TrieNode node=root;
        for(Character ch:word.toCharArray())
        {
            if(node.children.containsKey(ch))
            {
            node = node.children.get(ch);
            }
            else
            {
             TrieNode newNode = new TrieNode();    
             node.children.put(ch,newNode);
                node = newNode;
            }

            }
        node.word=word;
        }
        
        for(int row=0;row<board.length;row++)
        {
          for(int col=0;col<board[0].length;col++)
          {
              if(root.children.containsKey(board[row][col]))
              {
                  backtrack(row,col,root,board,result);
              }
          }
        }

        return result;
    }//T-(M(4*3^L-1)) , S-O(N) m is # of cell on board and L is mox word length and N is total # of letter in dict
        
    void backtrack(int row,int col,TrieNode parent,char[][] board,ArrayList<String> result)
    {
     Character letter =  board[row][col];
     TrieNode currNode =parent.children.get(letter); 
      
        if(currNode.word != null)
        {
            result.add(currNode.word);
            currNode.word = null;
        }
        
        board[row][col] ='#';
        
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset ={0,1,0,-1};
        
        for(int i=0;i<4;i++)
        {
            int newRow = row+rowOffset[i];
            int newCol = col+colOffset[i];
            
            if(newRow<0 || newRow>=board.length || newCol<0 || newCol>=board[0].length)
            {
                continue;
            }
            if(currNode.children.containsKey(board[newRow][newCol]))
            {
             backtrack(newRow,newCol,currNode,board,result);
            }
        }
        
        board[row][col] =letter;
        
        if(currNode.children.isEmpty())
        {
            parent.children.remove(letter);
        }
    }
}