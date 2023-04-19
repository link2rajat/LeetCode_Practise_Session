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
    int pathLength=0;
    public int longestZigZag(TreeNode root) {
        
        dfsHelper(root,false,0);
        dfsHelper(root,true,0);
        return pathLength;
    }//T-O(n),S-O(n)
    
    void dfsHelper(TreeNode node,boolean goLeft,int steps){
        if(node == null){
            return;
        }
        pathLength= Math.max(pathLength,steps);
        if(goLeft){
        dfsHelper(node.left,false,steps+1);
        dfsHelper(node.right,true,1);
        } else {
        dfsHelper(node.left,false,1);
        dfsHelper(node.right,true,steps+1);
        }
    }
}