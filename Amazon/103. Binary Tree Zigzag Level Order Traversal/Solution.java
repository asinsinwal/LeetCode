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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextSet = new LinkedList<>();
        
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                
                if(temp.left != null)
                    nextSet.add(temp.left);
                if(temp.right != null)
                    nextSet.add(temp.right);
            }
            
            if(queue.isEmpty() && !nextSet.isEmpty()){
                queue = nextSet;
                nextSet = new LinkedList<>();
                result.add(level);
                level = new ArrayList<>();
            }
        }
        
        if(level.size() > 0)
            result.add(level);
        
        for(int i = 1; i < result.size(); i+=2){
            Collections.reverse(result.get(i));
        }
        
        return result;
    }
}