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
        createTreeStringWithIdandRecurse(root,result, new HashMap<String,Integer>(),new HashMap<Integer,Integer>());
        return result;
    }
    
          int createTreeStringWithIdandRecurse(TreeNode current,List<TreeNode> result,HashMap<String,Integer> hm,HashMap<Integer,Integer> idMap )
          {
              
              if(current==null) return 0;

              String treeName = current.val + ","+ createTreeStringWithIdandRecurse(current.left,result,hm,idMap)+","+createTreeStringWithIdandRecurse(current.right,result,hm,idMap);

              if(!hm.containsKey(treeName))
              hm.put(treeName,hm.size()+1);
              
              int id = hm.get(treeName);
              
              idMap.put(id,idMap.getOrDefault(id,0)+1);
              

              if(idMap.get(id)==2) result.add(current);
              
              return id;
          }

}//T-O(n) , S-O(n)