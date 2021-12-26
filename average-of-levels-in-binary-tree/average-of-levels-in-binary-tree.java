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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
 
        if(root == null)
        {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        { 
            long count = queue.size();
            long sum=0;
                for(long i=0;i<count;i++)
                {
                    
                    TreeNode node = queue.poll();

                    sum+=node.val;
                    
                    if(node.left !=null)
                    {
                        queue.offer(node.left);
                    }
                    
                    if(node.right !=null)
                    {
                        queue.offer(node.right);
                    }
                }
            result.add((sum*1.0 /count));
        }
        
        return result;
    }
}//T-O(n),S-O(m)