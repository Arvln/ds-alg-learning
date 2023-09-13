package queue;

public class PriorityQueue2<T extends Priority> implements Queue<T> {
    private Priority[] array;
    private int size = 0;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    private void insert(T value) {
        int i;
        for (i = size - 1; i >= 0 && array[i].priority() > value.priority() ; i--) {
            array[i + 1] = array[i];
        }
        array[i + 1] = value;
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) return false;

        insert(value);
        size = size + 1;
        return true;
    }

    @Override
    @SuppressWarnings("all")
    public T poll() {
        if (isEmpty()) return null;

        T removed = (T) array[size - 1];
        size = size - 1;
        array[size] = null;
        return removed;
    }

    @Override
    @SuppressWarnings("all")
    public T peek() {
        if (isEmpty()) return null;

        return (T) array[size - 1];
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
