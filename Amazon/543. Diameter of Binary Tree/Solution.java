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
    private int result = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        
        depth(root);
        return result-1;
    }
    
    private int depth(TreeNode n){
        if(n == null)
            return 0;
        
        int left = depth(n.left);
        int right = depth(n.right);
        
        result = Math.max(result, left + right + 1);
        return Math.max(left, right) + 1;
    }
}