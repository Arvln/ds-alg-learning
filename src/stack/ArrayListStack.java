package stack;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListStack<T> implements Stack<T>, Iterable<T> {
    private final T[] array;
    private int top = 0;

    @SuppressWarnings("all")
    public ArrayListStack(int capacity) {
        array = (T[])new Object[capacity];
    }

    @Override
    public boolean push(T value) {
        if (isFull()) return false;

        array[top] = value;
        top = top + 1;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;

        T value = array[top - 1];
        top = top - 1;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;

        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == array.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<T> {
        int current = top;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            T value = array[current - 1];
            current = current - 1;
            return value;
        }
    }
}
