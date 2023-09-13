package deque;

public interface Deque<T> {
    boolean offerFirst(T value);

    boolean offerLast(T value);

    T pollFirst();

    T pollLast();

    T peakFirst();

    T peakLast();

    boolean isEmpty();

    boolean isFull();
}
