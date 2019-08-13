class Node {
    int value;
    int key;
    Node prev;
    Node next;
    
    public Node() {}
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}


class DoublyLl{
    Node head;
    Node tail;
    
    public DoublyLl() {
        head = new Node();
        tail = new Node();
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
        this.head.prev = null;
        this.tail.next = null;
    }
    
    public void insertAtFirst(Node n){
        n.prev = this.head;
        n.next = this.head.next;
        this.head.next.prev = n;
        this.head.next = n;
    }
    
    public void removeNode(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
    
    public int removeTail(){
        int key = tail.prev.key;
        removeNode(tail.prev);
        return key;
    }
}


class LRUCache {
    //Define LinkedList and Map inside the 
    private int capacity;
    private Map<Integer, Node> cache;
    private DoublyLl dlist;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dlist = new DoublyLl();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        updateCacheDlist(key, cache.get(key));
        
        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        Node n = new Node(key, value);
        
        if(cache.containsKey(key))
            dlist.removeNode(cache.get(key));
        else if (cache.size() >= capacity){
            int g_key = dlist.removeTail();
            cache.remove(g_key);
        }
        
        dlist.insertAtFirst(n);
        cache.put(key, n);
    }
    
    private void updateCacheDlist(int key, Node n){
        dlist.removeNode(n);
        dlist.insertAtFirst(n);
        cache.put(key, n);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */