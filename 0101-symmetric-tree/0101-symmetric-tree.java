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
    public boolean isSymmetric(TreeNode root) {
        
        return isSymmetric(root,root);

    }

    boolean isSymmetric(TreeNode root1,TreeNode root2)
    {
        if(root1== null && root2==null) return true;
        if(root1== null || root2==null) return false;


        return (root1.val==root2.val) && isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);

    }
}//T-O(n),S-O(n)