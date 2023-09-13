package heap;

public class MinHeap {
    public int[] array;
    public int size;

    public MinHeap(int capacity) {
        array = new int[capacity];
    }

    public MinHeap(int[] array) {
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    public boolean offer(int offered) {
        if (isFull()) return false;

        up(offered);
        size = size + 1;
        return true;
    }

    public Integer poll() {
        return poll(0);
    }

    public Integer poll(int index) {
        if (isEmpty() || index >= size) return null;

        int removed = array[index];
        swap(index, size - 1);
        size = size - 1;
        down(index);
        return removed;
    }

    public Integer peak() {
        if (isEmpty()) return null;

        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void replace(int replaced) {
        if (isEmpty()) return;

        array[0] = replaced;
        down(0);
    }

    public void order() {
        while (size > 1) {
            swap(0, size - 1);
            size = size - 1;
            down(0);
        }
    }

    private void up(int offered) {
        int child = size;
        array[child] = offered;

        while (child > 0) {
            int parent = (child - 1) >>> 1;
            if (array[child] < array[parent]) {
                swap(child, parent);
            } else {
                break;
            }
            child = parent;
        }
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;

        if (left < size && array[left] < array[min]) {
            min = left;
        }

        if (right < size && array[right] < array[min]) {
            min = right;
        }

        if (min != parent) {
            swap(min, parent);
            down(min);
        }
    }

    private void swap(int current, int target) {
        int tmp = array[current];
        array[current] = array[target];
        array[target] = tmp;
    }
}
