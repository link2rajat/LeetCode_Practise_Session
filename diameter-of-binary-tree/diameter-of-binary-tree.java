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
class TreeInfo{
    int height;
    int diameter;
    TreeInfo(int diameter,int height){
        this.diameter=diameter;
        this.height=height;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
      return getTreeInfo(root).diameter;
    }
    
    TreeInfo getTreeInfo(TreeNode node){
        if(node==null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = getTreeInfo(node.left);
        TreeInfo right = getTreeInfo(node.right);
        
        int maxDiameterwithNode = left.height+right.height;
        int diameterwithoutNode = Math.max(left.diameter,right.diameter);
        int currentHeight = Math.max(left.height,right.height)+1;
        int currentDiameter = Math.max(maxDiameterwithNode,diameterwithoutNode);
        
        return new TreeInfo(currentDiameter,currentHeight);
    }
}