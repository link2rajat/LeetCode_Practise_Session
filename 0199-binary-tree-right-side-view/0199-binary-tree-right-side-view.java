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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans = new  ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        int rightMostNode=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                rightMostNode=node.val;
                
                if(node.left !=null){
                      queue.offer(node.left);
                }
                
                if(node.right !=null){
                      queue.offer(node.right);
                }
            }
            ans.add(rightMostNode);
        }
        
        return ans;
    }
}