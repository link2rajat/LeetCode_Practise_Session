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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)
            return result;
        
        zigZagLevelHelper(root,result,0);
        
        return result;
    }
    
    
    void zigZagLevelHelper(TreeNode node,List<List<Integer>> result,int level)
    {
        if(level>=result.size())
        {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(node.val);
            result.add(newLevel);
        }
        
        else{ 
         if(level%2==0)
         {
         result.get(level).add(node.val);
        }
         else
        {
         result.get(level).add(0,node.val);
        }
        }
        if(node.left!=null)
        zigZagLevelHelper(node.left,result,level+1);
        
        if(node.right!=null)
        zigZagLevelHelper(node.right,result,level+1);
 
    }
    
}//T-O(N),S-O(logN)