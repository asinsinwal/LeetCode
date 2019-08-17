import javafx.util.*;
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
    // private TreeNode result;
    
    // Method Recursion: Time O(N) and Space O(N) -> stack
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         utilLCA(root, p, q);
//         return this.result;
//     }
    
//     private boolean utilLCA(TreeNode node, TreeNode p, TreeNode q){
        
//         if(node == null)
//             return false;
        
//         int left = utilLCA(node.left, p, q) ? 1 : 0;
        
//         int right = utilLCA(node.right, p, q) ? 1 : 0;
        
//         int mid = (node == p || node == q) ? 1 : 0;
        
//         if(mid + left + right >= 2)
//             this.result = node;
        
//         return (mid + left + right > 0);
//     }
    
    // Iterative method with no parent tracking
    private static int bothPending = 2;
    private static int leftFound = 1;
    private static int bothFound = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        
        stack.push(new Pair<TreeNode, Integer>(root, bothPending));
        boolean oneNodeFound = false;
        
        TreeNode LCA = null;
        
        TreeNode childNode = null;
        
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parentNode = top.getKey();
            int parentState = top.getValue();
            
            if(parentState != bothFound){
                if(parentState == bothPending){
                    if(parentNode == p || parentNode == q){
                        if(oneNodeFound)
                            return LCA;
                        else {
                            oneNodeFound = true;
                            LCA = stack.peek().getKey();
                        }
                    }
                    childNode = parentNode.left;
                }else
                    childNode = parentNode.right;

                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parentNode, parentState - 1));

                if(childNode != null)
                    stack.push(new Pair<TreeNode, Integer>(childNode, bothPending));
            }else{
                if(LCA == stack.pop().getKey() && oneNodeFound)
                    LCA = stack.peek().getKey();
            }
              
        }
        return null;
    }
}