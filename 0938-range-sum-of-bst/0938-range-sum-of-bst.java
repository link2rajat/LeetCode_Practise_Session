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
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
         sum=0;
        dfsHelper(root,low,high);
        return sum;
    }//T-O(n),S-O(n)
    
    void dfsHelper(TreeNode node, int low, int high){
        
        if(node != null){
            if(node.val>=low && node.val<= high){
                sum+=node.val;
            }
            if(node.val>low){
                dfsHelper(node.left,low,high);
            }
            if(node.val<high){
                dfsHelper(node.right,low,high);
            }
        }
    }
}