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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int currentLevelSum=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode current = queue.remove();
                sum+=current.val;
                if(current.left !=null){
                    queue.offer(current.left);
                } 
                
                if(current.right !=null){
                    queue.offer(current.right);
                } 
            }
            currentLevelSum=sum;
        }
        return currentLevelSum;
    }
}