class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

    class LRUCache {
        int cap;
        HashMap<Integer, Node> map;
        Node left;
        Node right;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap<>();
            this.left = new Node(0,0);
            this.right = new Node(0,0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void insert(Node node) {
            Node pprev = this.right.prev;
            node.next = this.right;
            pprev.next = node;
            node.prev = pprev;
            this.right.prev = node;
        }
    

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insert(node);

        if (map.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
