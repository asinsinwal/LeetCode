/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return utilSerialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(data_arr));
        return utilDeserialize(list);
    }
    
    private String utilSerialize(TreeNode root, String result){
        if(root == null){
            result += "null,";
        }else{
            result += String.valueOf(root.val) + ",";
            result = utilSerialize(root.left, result);
            result = utilSerialize(root.right, result);
        }
        
        return result;
    }
    
    private TreeNode utilDeserialize(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        
        root.left = utilDeserialize(list);
        root.right = utilDeserialize(list);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));