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

//1st:--> https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram
//2nd-->3 min https://www.youtube.com/watch?v=peyO-Nu1jGc&ab_channel=SahilThakur ,https://www.youtube.com/watch?v=TO5zsKtc1Ic&ab_chann  el=TECHDOSE and https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java

class Solution {
    int max_count = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     
        pathSum(root);
        return max_count;
    }
    
    int pathSum(TreeNode node)
    {
     if(node == null)
         return 0;
        
        int left_max = Math.max(0,pathSum(node.left));
        int right_max = Math.max(0,pathSum(node.right));
        
        int currentsum = left_max+right_max+node.val;
        
        max_count = Math.max(max_count, currentsum);
        
        return Math.max(left_max,right_max)+node.val;    
        
    }
}//T-O(N),S-O(H), where N in # of nodes in tree and H is height of tree