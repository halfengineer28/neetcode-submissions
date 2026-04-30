class LRUCache {
     Map<Integer , Node> map;
     Node head;
    Node tail;
    int capacity; 
   
   

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map  = new HashMap<>();
        
    }

    public void insert(Node node){
            map.put(node.key, node);
            node.next = head.next;
            node.prev  = head;
            head.next = node;
            node.next.prev = node;
        
    }
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
        
    }

    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
            
        }
        insert(new Node(key, value));
        
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
