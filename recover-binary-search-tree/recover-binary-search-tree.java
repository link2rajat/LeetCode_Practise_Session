/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   
    TreeNode secondNode=null;
    TreeNode firstNode=null;
    
    TreeNode prevNode=new TreeNode(Integer.MIN_VALUE);
        
    public void recoverTree(TreeNode root) {
     
        recurseInOrder(root);
        int temp=firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val=temp;
    }
    
    
    void recurseInOrder(TreeNode node)
    {
        if(node==null)
            return;
        
        recurseInOrder(node.left);

         if(prevNode !=null)
         {
          if(node.val < prevNode.val)
           {
            if(firstNode==null)
            {
                firstNode=prevNode;
            }
            secondNode=node;
          }  
        }
        prevNode=node;
        recurseInOrder(node.right);
        
    }
    
}
//T-O(n),S-O(n)