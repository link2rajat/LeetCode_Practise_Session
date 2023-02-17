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
     int minDiff = Integer.MAX_VALUE;
    TreeNode prev;
    
    public int minDiffInBST(TreeNode root) {
        
        inOrderTraversal(root);
        
        return minDiff;
    }//T-O(N),S-O(h)
    
    void inOrderTraversal(TreeNode node){
        
        if(node==null){
            return;
        }
        inOrderTraversal(node.left);
        
        if(prev !=null){
            minDiff = Math.min(minDiff,node.val-prev.val);
        }
        prev = node;
        
        inOrderTraversal(node.right);
    }
}