class Exercise5_PriorityQueue {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        bubbleUp(heap.size() - 1);
    }

    private void bubbleUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent) >= heap.get(i)) break;

            int temp = heap.get(parent);
            heap.set(parent, heap.get(i));
            heap.set(i, temp);

            i = parent;
        }
    }

    public int peek() {
        if (heap.isEmpty()) throw new RuntimeException("Empty heap");
        return heap.get(0);
    }

    public int extractMax() {
        if (heap.isEmpty()) throw new RuntimeException("Empty heap");

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

    private void heapifyDown(int i) {
        int n = heap.size();

        while (true) {
            int largest = i;
            int left = 2*i + 1;
            int right = 2*i + 2;

            if (left < n && heap.get(left) > heap.get(largest)) largest = left;
            if (right < n && heap.get(right) > heap.get(largest)) largest = right;

            if (largest == i) break;

            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);

            i = largest;
        }
    }
}
