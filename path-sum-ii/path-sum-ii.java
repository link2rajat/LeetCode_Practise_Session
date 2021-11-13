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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null)
        {    
         return result;
        }
        
        pathsumHelper(root,targetSum,result,path);
        
        return result;
        
    }
    
    
    void pathsumHelper(TreeNode node, int remainSum,List<List<Integer>> result,List<Integer> path)
    {
        
        if(node==null)
        {    return;
       
         }
        
        path.add(node.val);
        
        if(node.val==remainSum && node.left==null && node.right==null)
        {
            result.add(new ArrayList<>(path));
        }
        
        else{
        pathsumHelper(node.left,remainSum-node.val,result,path);
        pathsumHelper(node.right,remainSum-node.val,result,path);
             }        
        path.remove(path.size()-1);
    }
}//T-O(n^2),S-O(n)where n is number of nodes