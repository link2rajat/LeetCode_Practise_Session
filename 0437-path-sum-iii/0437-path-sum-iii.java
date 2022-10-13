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
    HashMap<Long,Integer> sumMap = new HashMap<>();
    int target=0;
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        target=targetSum;
        findPathSum(root,0);
        return count;
    }
    
    void findPathSum(TreeNode node,long currentSum)
    {
        if(node== null)
        {
            return;
        }
        
        currentSum+=node.val;
        if(currentSum==target)
        {
            count++;
        }
        
        count+=sumMap.getOrDefault((currentSum-target),0);
        
        sumMap.put(currentSum,sumMap.getOrDefault(currentSum,0)+1);
        
        findPathSum(node.left,currentSum);
        findPathSum(node.right,currentSum);
        
        sumMap.put(currentSum,sumMap.getOrDefault(currentSum,0)-1);
        
    }
}//T-O(N),S-O(N)