class MedianFinder {
    private PriorityQueue<Integer> maxheap;

    private PriorityQueue<Integer> minheap;

    public MedianFinder() {
        this.maxheap = new PriorityQueue<>((a, b) -> b - a);
        this.minheap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        maxheap.add(num);

        if (maxheap.size() - minheap.size() > 1 || !minheap.isEmpty()
            && maxheap.peek() > minheap.peek()) {
                minheap.add(maxheap.poll());
        }

        if (minheap.size() - maxheap.size() > 1){
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if (minheap.size() == maxheap.size()){
            return (double) (minheap.peek() + maxheap.peek()) / 2.0;
        }else if(minheap.size() > maxheap.size()){
            return minheap.peek();
        }else{
            return maxheap.peek();
        }

    }
}
