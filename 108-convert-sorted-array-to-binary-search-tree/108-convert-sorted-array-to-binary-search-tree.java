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

/*

Get the middle element of array and make it root , left subtree -> start ti mid and right -> mid to right
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return buildBST(nums, 0 , nums.length-1);
        
    }//T-O(N), S-O(log N)
    
    TreeNode buildBST(int[] nums, int left, int right)
    {
        if(left>right) return null;
        
        int mid = left + ((right-left)/2);

        TreeNode node = new TreeNode(nums[mid]);
        node.left =  buildBST(nums, left , mid-1);
        node.right =  buildBST(nums, mid+1 , right);

        return node;
        
    }
}