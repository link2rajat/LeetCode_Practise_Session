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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
         dfs(root,paths, "");
        
        return paths;
    }
    
     void dfs(TreeNode root,List<String> paths,String s)
     {
         if(root != null )
         {
             s+=Integer.toString(root.val);
             
             if((root.left== null) && (root.right == null))
             {    
                 paths.add(s);
             }
         else
         {
             s+="->";
             dfs(root.left,paths,s);
             dfs(root.right,paths,s);    

         }
        }
     }

    
}//T-O(N),S-O(logN)