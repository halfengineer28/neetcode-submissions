class MedianFinder {

    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>((a, b) -> a - b);
        maxheap = new PriorityQueue<>(( a, b) -> b - a);
        
    }
    
    public void addNum(int num) {
        maxheap.add(num);

        if (maxheap.size() - minheap.size() > 1 || !minheap.isEmpty() && maxheap.peek() > minheap.peek()){
            minheap.add(maxheap.poll());
        }
        
        if (minheap.size() - maxheap.size() > 1){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {

        if (minheap.size() > maxheap.size()){
            return minheap.peek();
        }else if (maxheap.size() > minheap.size()){
            return maxheap.peek();
        }else{
            return (double)(maxheap.peek() + minheap.peek()) / 2.0;
        }
        
    }
}
