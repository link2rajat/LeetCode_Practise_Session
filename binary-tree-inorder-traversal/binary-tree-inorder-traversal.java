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
   
    List<Integer> result = new ArrayList<Integer>();
        
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
        {
            return result;
        }
        
         traversal(root);
        return result;
    }
    
    void traversal(TreeNode node)
    {
        
        if(node==null)
            return;
        
        traversal(node.left);
        
        result.add(node.val);
        
        traversal(node.right);
        
    }
    
}//T-O(n),S-O(n)