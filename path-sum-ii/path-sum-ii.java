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
        recursive_path(result,path,targetSum,root);
        return result;
        
    }
                       
    void recursive_path( List<List<Integer>> result,List<Integer> path,int targetSum,TreeNode node)
    {
        if(node==null)
            return;
        
        path.add(node.val);
        
        if(node.left==null && node.right==null && targetSum==node.val)
        {
            result.add(new ArrayList<>(path));
            
        }
        else
        {
            recursive_path(result,path,targetSum-node.val,node.left);
                
                recursive_path(result,path,targetSum-node.val,node.right);
        }
    
        path.remove(path.size()-1);
    }
}//T-O(n^2,S-O(n)