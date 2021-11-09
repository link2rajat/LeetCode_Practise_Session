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
    public int sumOfLeftLeaves(TreeNode root) {
       
        if(root ==null)
       {
           return 0;
       }        
        
        int sum=0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        stack.push(root);
        
        while(!stack.isEmpty())
        {
        TreeNode subnode = stack.pop();

    if(isleaf(subnode.left))
       {
        sum+=subnode.left.val; 
       }
            
       
        if(subnode.right != null)
        {
         stack.push(subnode.right);
        }
        if(subnode.left != null)
        {
        stack.push(subnode.left);
        }
        
        }
            return sum;
        
    }
    
    boolean isleaf(TreeNode node)
    {
        return node != null &&(node.left==null && node.right==null);
    }
}//T-O(N),S-O(N)