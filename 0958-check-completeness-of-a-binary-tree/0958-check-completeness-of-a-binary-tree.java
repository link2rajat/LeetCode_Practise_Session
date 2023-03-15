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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        boolean nullFound = false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node==null){
                nullFound=true;
            }else{
                if(nullFound){
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}//T-O(N),S-O(N)