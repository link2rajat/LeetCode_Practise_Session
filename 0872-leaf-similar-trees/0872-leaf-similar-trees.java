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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaftList1 = new ArrayList<>();
        List<Integer> leaftList2 = new ArrayList<>();
        findLeafForTreeDfs(root1,leaftList1);
        findLeafForTreeDfs(root2,leaftList2);
        return leaftList1.equals(leaftList2);
    }//T-O(m+n),S-O(m+n)
    
    void findLeafForTreeDfs(TreeNode node,List<Integer> leaftList){
        if(node!=null){
        if(node.left == null && node.right==null)
            leaftList.add(node.val);
         findLeafForTreeDfs(node.left,leaftList);
         findLeafForTreeDfs(node.right,leaftList);
        }
    }
        
}