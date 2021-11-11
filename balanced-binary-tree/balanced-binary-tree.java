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
    public boolean isBalanced(TreeNode root) {
     if(root == null)
         return true;
        
        
        return Math.abs(calculateheight(root.left)-calculateheight(root.right))<2 && isBalanced(root.left)&& isBalanced(root.right);

    }
    
    int calculateheight(TreeNode node)
    {
        if(node==null)
            return 0;
        
        int leftHeight,rightHeight;
       
        leftHeight  = calculateheight(node.left);
       
        rightHeight = calculateheight(node.right);
        
        
        return Math.max(leftHeight,rightHeight)+1;
        
    }
}//T-O(nlogn),S-O(n)where n is number of treenode and logn is because of heigh of tree