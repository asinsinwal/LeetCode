/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    Map<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;
        
        
        if(visited.containsKey(head))
            return visited.get(head);
        
        Node new_node = new Node(head.val, null, null);
        
        visited.put(head, new_node);
        
        
        new_node.next = copyRandomList(head.next);
        new_node.random = copyRandomList(head.random);
        
        return new_node;
        
    }
}