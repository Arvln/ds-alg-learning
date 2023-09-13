package bubble_sort;

public class Sort {
    private static void bubbleSortHelper(int[] unsortedArray, int last) {
        if (last == 0) return;

        int exchangedPoint = 0;

        for (int i = 0; i < last; i++) {
            if (unsortedArray[i] > unsortedArray[i + 1]){
                int tmp = unsortedArray[i];
                unsortedArray[i] = unsortedArray[i + 1];
                unsortedArray[i + 1] = tmp;
                exchangedPoint = i;
            }
        }

        bubbleSortHelper(unsortedArray, exchangedPoint);
    }

    public static void bubbleSort(int[] unsortedArray) {
        bubbleSortHelper(unsortedArray, unsortedArray.length - 1);
    }

    private static void insertionSortHelper(int[] unsortedArray, int first) {
        if (first == unsortedArray.length) return;

        int currentIndex = first - 1;
        int selected = unsortedArray[first];
        while (currentIndex >= 0 && unsortedArray[currentIndex] > selected) {
            unsortedArray[currentIndex + 1] = unsortedArray[currentIndex];
            currentIndex = currentIndex - 1;
        }

        unsortedArray[currentIndex + 1] = selected;

        insertionSortHelper(unsortedArray, first + 1);
    }

    public static void insertionSort(int[] unsortedArray) {
        insertionSortHelper(unsortedArray, 1);
    }
}
