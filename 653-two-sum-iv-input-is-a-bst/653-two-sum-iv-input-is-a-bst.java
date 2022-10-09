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
    public boolean findTarget(TreeNode root, int k) {
         List<Integer> treeVal = new ArrayList<>();
        
        serialiseTree(treeVal,root);
        
        boolean result = twoSum(treeVal,k);
        
        return result;
    }
    
    void serialiseTree( List<Integer>valList,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
      
        if(root.left !=null)
        {
            serialiseTree(valList,root.left);
        }
        valList.add(root.val);
        if(root.right !=null)
        {
            serialiseTree(valList,root.right);
        }
    }
        
        boolean twoSum(List<Integer> treeVal,int target)
        {
            int left=0;
            int right=treeVal.size()-1;
            
            while(left<right)
            {
                int sum=treeVal.get(left)+treeVal.get(right);
                if(sum==target)
                {
                    return true;
                }
                else if(sum<target)
                {
                    left++;
                   
                }
                else
                {
                    right--;
                }
            }
            
            return false;
        }
        
}