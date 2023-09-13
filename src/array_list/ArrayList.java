package array_list;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayList {
    int size = 0;
    int capacity = 8;
    int[] data = {};

    /**
     *
     * @param element insert target
     * @return element position
     */
    public int addLast(int element) throws Exception {
        return put(size, element);
    }

    public void checkSpaceAndExtend() {
        if (size == capacity) {
            capacity = capacity + (capacity >>> 1);
            int[] newArray = new int[capacity];
            System.arraycopy(data, 0, newArray, 0, size);
            data = newArray;
        }
    }

    /**
     *
     * @param position insert position
     * @param element insert element
     * @return element position
     */
    public int put(int position, int element) throws Exception {
        if (position < 0) return position;
        if (position > size) {
            throw new Exception("Position out of boundary");
        }
        if (size == 0) data = new int[capacity];

        checkSpaceAndExtend();

        System.arraycopy(data, position, data, position + 1, size - position);

        data[position] = element;
        size = size + 1;

        return position;
    }

    /**
     *
     * @param position target position
     * @return target element
     */
    public int get(int position) throws Exception {
        if (position < 0) {
            throw new Exception("Position should be a positive int");
        }
        if (position >= size) {
            throw new Exception("Position out of boundary");
        }

        return data[position];
    }

    /**
     *
     * @param position target position
     * @return element be removed
     */
    public int delete(int position) throws Exception {
        if (position < 0) {
            throw new Exception("Position should be a positive int");
        }
        if (position >= size) {
            throw new Exception("Position out of boundary");
        }

        int removedElement = data[position];

        if (size - position > 1) {
            System.arraycopy(data, position + 1, data, position, size - position - 1);
        }

        size = size - 1;

        return removedElement;
    }

    public int size() {
        return size;
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(data, 0 ,size));
    }
}
