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
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
                if(root==null)
                    return levels;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        boolean  even=true;
        
        while(!queue.isEmpty()){
            
            int size=queue.size();
            
            LinkedList<Integer> level = new LinkedList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode current = queue.poll();
                
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(even)
                    level.add(current.val);
                else
                    level.addFirst(current.val);
            }
            levels.add(level);
            even=!even;
            }
        return levels;
    }
}