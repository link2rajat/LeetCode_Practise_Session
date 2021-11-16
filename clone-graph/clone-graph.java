/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        
       
        if(node==null)return node;  
        
        
        if(map.containsKey(node))
        {
         return map.get(node); 
        }

        Node clonedNode = new Node(node.val,new ArrayList());
            
        map.put(node,clonedNode);
        
        
        for(Node neighbour:node.neighbors)
        {
            
            clonedNode.neighbors.add(cloneGraph(neighbour));
            
        }
        
        return clonedNode;
        
    }
    
}//T-O(N+M) , S- O(N) where N is # of vertices and M is edges