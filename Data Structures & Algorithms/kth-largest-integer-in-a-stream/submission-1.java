class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        // Add all initial numbers
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        // Add new value
        minHeap.offer(val);

        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Top of min-heap = kth largest
        return minHeap.peek();
    }
}