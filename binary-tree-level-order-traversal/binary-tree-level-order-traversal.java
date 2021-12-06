/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        {  
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
        List<Integer> levelList = new ArrayList<>(levelSize);
            
            for(int index=0;index<levelSize;index++)
            {
              TreeNode nodeVal = queue.poll();
              levelList.add(nodeVal.val);
          
              if(nodeVal.left !=null)
              {
                  queue.add(nodeVal.left);
              }
                
              if(nodeVal.right !=null)
              {
                  queue.add(nodeVal.right);
              }
                
            }
            result.add(levelList);
        }
        
        return result;
    }

}//T-O(n),S-O(n)