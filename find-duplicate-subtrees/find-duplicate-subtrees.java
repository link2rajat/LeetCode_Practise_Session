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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       
        List<TreeNode> result = new ArrayList<>();
        createTreeStringandRecurse(root,result, new HashMap<String,Integer>());
        return result;
    }
    
          String createTreeStringandRecurse(TreeNode current,List<TreeNode> result,HashMap<String,Integer> hm)
          {
              
              if(current==null)return "#";

              String treeName = current.val + ","+ createTreeStringandRecurse(current.left,result,hm)+","+createTreeStringandRecurse(current.right,result,hm);

              hm.put(treeName,hm.getOrDefault(treeName,0)+1);

              if(hm.get(treeName)==2) result.add(current);
              
              return treeName;
          }

}//T-O(n^2) , S-O(n)