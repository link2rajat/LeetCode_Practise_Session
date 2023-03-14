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

     int sum =0;
    public int sumNumbers(TreeNode root) {

        sumDfsRecursion(root,0);
        return sum;
    }//T-O(N),S-O(H)
    
    void sumDfsRecursion(TreeNode node,int currentSum){
      
        if(node !=null){
        currentSum= currentSum*10+node.val;
        if(node.left==null && node.right==null){
            sum+=currentSum;
        }
            sumDfsRecursion(node.left,currentSum);
            sumDfsRecursion(node.right,currentSum);
        }
    }
}