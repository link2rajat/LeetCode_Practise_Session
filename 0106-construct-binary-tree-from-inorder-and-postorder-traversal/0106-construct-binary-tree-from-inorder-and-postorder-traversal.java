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
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        int index = 0;
        for(Integer val: inorder){
            inOrderMap.put(val,index++);
        }
        postOrderIndex = postorder.length-1;
        return constructTree(0,inorder.length-1,inorder,postorder,inOrderMap);
    }//T-O(N),S-O(N)
    
    TreeNode constructTree(int inOrderLeft,int inOrderRight,
                           int[] inorder,int[] postorder,HashMap<Integer,Integer> inOrderMap){
        if(inOrderLeft > inOrderRight)
            return null;
        
        int rootValue = postorder[postOrderIndex];
        TreeNode root = new TreeNode(rootValue);
        
        int index = inOrderMap.get(rootValue);
        
        postOrderIndex--;
        
        root.right = constructTree(index+1,inOrderRight,inorder,postorder,inOrderMap);
        
        root.left = constructTree(inOrderLeft, index-1,inorder,postorder,inOrderMap);
        
        return root;
    }
}