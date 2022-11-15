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

//https://www.youtube.com/watch?v=CvrPf1-flAA&ab_channel=TECHDOSE   -->Concept , https://www.youtube.com/watch?v=i_r2uKbwHCU&ab_channel=KnowledgeCenter --> Java code
class Solution {
 
    public int countNodes(TreeNode root) {
        if(root == null)
        { 
            return  0;
        }
 
        TreeNode leftNode = root, rightNode = root;
        int leftNodeCount = 0, rightNodeCount = 0; 
 
        while(leftNode != null)
        {
            leftNodeCount++;
            leftNode=leftNode.left;
        }
        
         while(rightNode != null)
        {
            rightNodeCount++;
            rightNode=rightNode.right;
        }
        
        if(leftNodeCount == rightNodeCount)
            return (1<<leftNodeCount)-1;
        
        return 1 + countNodes(root.left)+ countNodes( root.right);
    }
    
 
}