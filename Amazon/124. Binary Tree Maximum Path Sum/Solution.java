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
    // Method: Recursive O(N) & O(log(N))
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return sum;
    }
    
    private int max_gain(TreeNode root){
        if(root == null)
            return 0;
        
        int left_gain = Math.max(max_gain(root.left), 0);
        int right_gain = Math.max(max_gain(root.right), 0);
        
        int newSum = root.val + left_gain + right_gain;
        
        sum = Math.max(sum, newSum);
        
        return root.val + Math.max(left_gain, right_gain);
    }
}