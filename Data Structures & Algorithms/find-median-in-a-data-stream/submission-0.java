class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b)->a.compareTo(b));
        maxHeap = new PriorityQueue<>((a,b)->b.compareTo(a));
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);

        } else {
            maxHeap.offer(num);
        }
        if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            rebalance();
        }
    }

    public void rebalance() {
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if(minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }
    }
}
