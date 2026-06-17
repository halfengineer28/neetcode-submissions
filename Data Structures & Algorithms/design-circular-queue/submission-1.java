class Node {
    int val;
    Node next;
    Node prev;
    Node (int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularQueue {
    int size;
    Node left;
    Node right;

    public MyCircularQueue(int k) {
        size = k;
        left = new Node (0, null, null);
        right = new Node(0, null, left);
        left.next = right;
        
    }
    
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        Node node = new Node(value, right, right.prev);
        right.prev.next = node;
        right.prev = node;
        size--;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        left.next = left.next.next;
        left.next.prev = left;
        size++;
        return true;
        
    }
    
    public int Front() {

        return isEmpty() ? -1 : left.next.val;
        
    }
    
    public int Rear() {
        return isEmpty() ? -1 : right.prev.val;
        
    }
    
    public boolean isEmpty() {
        return left.next == right;
        
    }
    
    public boolean isFull() {
        return size == 0;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */