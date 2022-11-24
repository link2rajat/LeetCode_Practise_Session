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
    public TreeNode invertTree(TreeNode root) {
        helperInvertTree(root);
        return root;
    }
    
    void helperInvertTree(TreeNode node)
    {
        if( node == null )
        {
            return;
        }
        
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
        
        helperInvertTree(node.left);
        helperInvertTree(node.right);
        
    }
}