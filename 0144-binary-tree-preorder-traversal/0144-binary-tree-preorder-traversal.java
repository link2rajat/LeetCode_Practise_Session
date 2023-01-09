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
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        preorder(root);
        return result;     
    }//T-O(n),S-O(n)
    
    void preorder(TreeNode node){
        if(node==null)
            return;   
        result.add(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
}