/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
    
        if(root== null)return;
        
        flattenHelper(root);
        
    }
    
    TreeNode  flattenHelper(TreeNode node)
    {
        //for null nodes do nothing
        if(node== null)
            return null;
        
        //for leaf node return node as it is 
        if(node.left== null && node.right==null)
            return node;
        //flatten left subtree via recursion
        TreeNode lefTail= flattenHelper(node.left);
        
        //flatten right subtree via recursion
        TreeNode rightTail= flattenHelper(node.right);
        
        //moving left skewed tree to right and appending right skewed tree as right child of it
        if(lefTail!=null)
        {
          lefTail.right = node.right;
            node.right = node.left;
            node.left= null;
        }
        //return rightTail if it's not null or else return lefttail
        return rightTail== null ? lefTail: rightTail;
        
    }
    
}//T-O(n),S-O(n) where n is # of nodes in tree