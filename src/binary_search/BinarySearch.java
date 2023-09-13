package binary_search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    /**
     *
     * @param orderArray order array use to search target
     * @param target target value
     * @param first point to first index
     * @param last point to last index
     * @return if first > last return -(insertion point + 1), else return right most index
     */
    public static int searchHelper(int[] orderArray, int target, int first, int last, int result) {
        if(first > last) return result;

        int middleIndex = (first + last) >>> 1;
        int middleValue = orderArray[middleIndex];

        if (target < middleValue) {
            return searchHelper(orderArray, target, first, middleIndex - 1, result);
        } else {
            first = middleIndex + 1;

            if (target == middleValue) {
                result = middleIndex;
            } else {
                result = -(first + 1);
            }
            return searchHelper(orderArray, target, first, last, result);
        }
    }
    /**
     *
     * @param orderArray order array use to search target
     * @param target target value
     * @return target value index in the array, return -1 if search nothing
     */
    public static int search(int[] orderArray, int target) {
        return searchHelper(orderArray, target, 0, orderArray.length - 1, -1);
    }
}
