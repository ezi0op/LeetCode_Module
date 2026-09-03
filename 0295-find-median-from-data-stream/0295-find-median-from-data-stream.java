class MedianFinder {

   	// smaller half with maxNum
		private PriorityQueue<Integer> maxHeap;
		// larger half with minNum
		private PriorityQueue<Integer> minHeap;

		public MedianFinder() {
			maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			minHeap = new PriorityQueue<>();
		}

		// add number to the data structure
		public void addNum(int num) {
			// add number to the maxHeap
			maxHeap.offer(num);
			// if the maxHeap is not empty and the top of the maxHeap is greater than the
			// top of the minHeap then we will move the top of the maxHeap to the minHeap
			if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				minHeap.offer(maxHeap.poll());
			}
			// balance the size of the maxHeap and minHeap
			// by adding the top of the maxHeap to the minHeap if the size of the maxHeap is
			// greater than the size of the minHeap + 1
			if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}

			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}

		}

		public double findMedian() {

			// if the size of the maxHeap is greater than the size of the minHeap then we
			// will return the top of the maxHeap as the median
			if (maxHeap.size() > minHeap.size()) {
			    return maxHeap.peek();
			}
			// if the size of the maxHeap is equal to the size of the minHeap then we will
			// return the average of the top of the maxHeap and the top of the minHeap as
			// the median
			return (maxHeap.peek() + minHeap.peek()) / 2.0;

        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */