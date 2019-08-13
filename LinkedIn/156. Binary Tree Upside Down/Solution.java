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
    
    // Method: Stack
//     public TreeNode upsideDownBinaryTree(TreeNode root) {
//         if(root == null)
//             return root;

//         // Define stack for reverse effect
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(root != null){
//             stack.push(root);
//             root = root.left;
//         }
        
//         root = stack.peek();
        
//         TreeNode reverse = null;
        
//         while(!stack.isEmpty()){
//             reverse = stack.pop();
//             if(stack.size() == 0){
//                 reverse.left = null;
//                 reverse.right = null;
//                 break;
//             }
//             reverse.right = stack.peek();
//             reverse.left = stack.peek().right;
//         }
        
//         return root;
//     }
    
    // Method: Iterative
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        
        // Define nodes for iterative
        TreeNode current = root;
        TreeNode previous = null;
        TreeNode next = null;
        TreeNode prev_node_right = null;
        
        while(current != null){
            next = current.left;
            
            //swapping values
            current.left = prev_node_right;
            prev_node_right = current.right;
            current.right = previous;
            
            previous = current;
            current = next;
        }
        
        return previous;
    }
}