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
    
    // Not a good answer for this question; Solution for Complete Binary Tree
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         int height = 1;
//         // Define variables for the loo
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         List<Integer> current = new ArrayList<Integer>();
//         int count = 0;
        
//         while(!queue.isEmpty()){
//             if(count == height){
//                 result.add(current);
//                 count = 0;
//                 height *= 2;
//                 current = new ArrayList<Integer>();
//             }
            
//             TreeNode node = queue.remove();
            
//             if(node == null){
//                 count++;
//                 continue;
//             }
            
//             current.add(node.val);
//             count++;
//             queue.add(node.left);
//             queue.add(node.right);
//         }
        
//         return result;
//     }
    
    // Method 2; Calculate on height
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return result;
        
        utilLevelOrder(root, 0);
        
        return result;
    }
    
    private void utilLevelOrder(TreeNode node, int height){
        // create new arraylist for the level
        if(result.size() == height)
            result.add(new ArrayList<Integer>());
        
        // add the value
        result.get(height).add(node.val);
        
        // call the util function for non-empty nodes
        if(node.left != null)
            utilLevelOrder(node.left, height+1);
        if(node.right != null)
            utilLevelOrder(node.right, height+1);
    }
}