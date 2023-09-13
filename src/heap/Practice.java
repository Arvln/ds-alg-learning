package heap;

public class Practice {
    public MinHeap heap;

    public Practice(int[] nums, int k) {
        if (k < 0) return;

        this.heap = new MinHeap(k);

        for (int num: nums) {
            add(num);
        }
    }

    public Integer findKthLargest() {
        return heap.peak();
    }

    public int add(int value) {
        if (!heap.isFull()) {
            heap.offer(value);
        } else if (value > heap.peak()) {
            heap.replace(value);
        }

        return findKthLargest();
    }
}
