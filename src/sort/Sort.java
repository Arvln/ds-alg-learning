package sort;

import java.util.concurrent.ThreadLocalRandom;

public class Sort {
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void bubbleSort(int[] array) {
        int unSortedBound = array.length - 1;

        while (unSortedBound != 0) {
            int changed = 0;
            for (int j = 0; j < unSortedBound; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    changed = j;
                }
            }
            unSortedBound = changed;
        }
    }

    public static void selectedSort(int[] array) {
        int last = array.length;

        while (last > 1) {
            int max = 0;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
            }
            last--;
            swap(array, max, last);
        }

    }

    private static void insertionSortHelper(int[] array, int left) {
        if (left == array.length) return;

        int currentIndex = left - 1;
        int selected = array[left];

        while (currentIndex >= 0 && array[currentIndex] > selected){
            array[currentIndex + 1] = array[currentIndex];
            currentIndex = currentIndex - 1;
        }

        array[currentIndex + 1] = selected;

        insertionSortHelper(array, left + 1);
    }

    public static void insertionSort(int[] array) {
        insertionSortHelper(array, 1);
    }

    public static void quickSort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) return;

        int p = partition2(a, left, right);
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    private static int partition1(int[] a, int left, int right) {
        int index = ThreadLocalRandom.current().nextInt(right-left+1) + left;
        int i = left;
        int j = left;

        swap(a, index, right);

        while (j < right) {
            if (a[j] < a[right]) {
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
            j++;
        }

        swap(a, i, right);

        return i;
    }

    private static int partition2(int[] a, int left, int right) {
        int index = ThreadLocalRandom.current().nextInt(right-left+1) + left;
        int i = left;
        int j = right;

        swap(a, left, index);

        while (i < j) {
            while (i < j && a[j] > a[left]) {
                j--;
            }
            while (i < j && a[i] <= a[left]) {
                i++;
            }

            swap(a, i, j);
        }

        swap(a, left, i);
        return i;
    }
}
