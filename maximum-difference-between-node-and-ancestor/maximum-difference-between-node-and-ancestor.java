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
//https://www.youtube.com/watch?v=s9_heukqqS4
class Solution {
    int diff=0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return diff;
    }
    
    int[] dfs(TreeNode node){
        
        if(node==null)return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        
        if(node.left==null && node.right==null)
            return new int[]{node.val,node.val};
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int min = Math.min(left[0],right[0]);
        int max = Math.max(left[1],right[1]);
        
        diff = Math.max(diff,Math.max(Math.abs(node.val-min),Math.abs(node.val-max)));
        
        min=Math.min(min,node.val);
                max=Math.max(max,node.val);
        
        return new int[]{min,max};
    }
    
}