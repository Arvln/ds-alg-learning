package queue;

public class PriorityQueue1<T extends Priority> implements Queue<T> {
    private Priority[] array;
    private int size = 0;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) return false;

        array[size] = value;
        size = size + 1;
        return true;
    }

    private int useMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    private void remove(int index) {
        if (index < 0) return;
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size = size - 1;
        array[size] = null;
    }

    @Override
    @SuppressWarnings("all")
    public T poll() {
        if (isEmpty()) return null;

        int max = useMax();
        T removed = (T) array[max];
        remove(max);
        return removed;
    }

    @Override
    @SuppressWarnings("all")
    public T peek() {
        if (isEmpty()) return null;

        return (T) array[useMax()];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
