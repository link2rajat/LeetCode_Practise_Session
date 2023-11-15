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
    public int closestValue(TreeNode root, double target) {
        List<Integer> nums = new ArrayList<>();
        inorderTraversal(root,nums);
        return Collections.min(nums,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
            return Math.abs(o1-target)<Math.abs(o2-target) ?-1:1;
            }
        });
        
    }
    void inorderTraversal(TreeNode node,List<Integer> nums ){
        if(node==null)
            return;
         inorderTraversal(node.left,nums);
         nums.add(node.val);   
         inorderTraversal(node.right,nums);
    }
}