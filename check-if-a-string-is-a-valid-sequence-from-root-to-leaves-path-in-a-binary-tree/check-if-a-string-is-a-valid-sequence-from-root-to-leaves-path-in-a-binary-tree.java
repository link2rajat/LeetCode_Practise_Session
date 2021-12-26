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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        
        if(root ==null)
        {
            return arr.length==0;
        }
          return dfs(root,arr,0);
    }
    
    boolean dfs(TreeNode node, int[] arr, int seq)
    {
        if(node ==null)
        {
            return false;
        }
        
        if(seq >= arr.length || node.val != arr[seq])
        {
            return false;
        }
        
        if(node.left== null && node.right==null && seq == arr.length-1)
        {
            return true;
        }
        
        return dfs(node.left,arr,seq+1) || dfs(node.right,arr,seq+1);
    }
}//T-O(N), S-O(N) where N is # of nodes in tree