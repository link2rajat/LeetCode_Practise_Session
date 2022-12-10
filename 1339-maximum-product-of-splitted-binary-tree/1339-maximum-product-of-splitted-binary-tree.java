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
    
    public int maxProduct(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> subTreeSumList = new ArrayList<>();
        long totalSum = treeSum(root,subTreeSumList);
        long bestProduct=0;
        for(Integer subtreeSum : subTreeSumList){
            bestProduct = Math.max(bestProduct,subtreeSum*(totalSum-subtreeSum));
        }
        
        return (int)(bestProduct%1000000007);
    }//T-O(n),S-O(n)
    
     int treeSum(TreeNode node,List<Integer> subTreeSumList){
        if(node==null){
            return 0;
        }
         
        int leftSum = treeSum(node.left,subTreeSumList);
        int rightSum = treeSum(node.right,subTreeSumList);
         
        int totalSum =  node.val+leftSum+rightSum;
        subTreeSumList.add(totalSum);
        return totalSum;

     }
    
}