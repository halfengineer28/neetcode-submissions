class KthLargest {
    int size;
    PriorityQueue<Integer> pq;
    int [] arr;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        this.pq = new PriorityQueue<>(( a,  b) ->  a-b);
        this.arr = nums;

        for (int i = 0; i < arr.length; i++){
            pq.add(nums[i]);
        } 
        
        while (pq.size() > size){
            pq.poll();

        }
    }
    
    public int add(int val) {
        pq.add(val);

        while (pq.size() > size){
            pq.poll();

        }
        return pq.peek();

        
    }
}
