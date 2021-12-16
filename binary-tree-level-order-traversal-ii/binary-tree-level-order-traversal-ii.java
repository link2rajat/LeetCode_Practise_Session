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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        
        if(root == null) return result;
        //dequeue as queue
        Deque<TreeNode> queue = new ArrayDeque<>();
        
           queue.offer(root); 

        while(!queue.isEmpty())
        {
            
           int size = queue.size(); 
            
           List<Integer> level = new ArrayList<>(size);
           
            for(int i=0; i<size;i++)
            {
           
           TreeNode node = queue.poll();

                level.add(node.val);

            
            if(node.left != null)
            {
                queue.offer(node.left);
            }
            
            if(node.right != null)
            {
                queue.offer(node.right);
            }
            }
        //adding first each time 
        result.add(0,level);
        }
     return result;   
    }
}//T-O(n),S-O(n)