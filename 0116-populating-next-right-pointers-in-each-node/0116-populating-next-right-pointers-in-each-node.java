/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        
        Queue<Node> bfsQueue = new LinkedList<>();
        
        bfsQueue.add(root);

        
        while(bfsQueue.size()>0)
        {
            int size = bfsQueue.size();

            for(int index=0;index<size;index++)
            {
             Node newNod = bfsQueue.poll();
            
                 // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only 
                // don't establish next pointers beyond the end
                // of a level
                if(index<size-1)
                {
                    newNod.next = bfsQueue.peek();
                }
            
            if(newNod.left !=null)
            {
                bfsQueue.add(newNod.left);
            }
            
           if(newNod.right !=null)
            {
                bfsQueue.add(newNod.right);
            }
            }
        }
        
        return root;
    }
}//T-O(n),S-O(n)