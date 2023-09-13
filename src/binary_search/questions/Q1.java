package binary_search.questions;

public class Q1 {
    /**
     *
     * @param nums order number array
     * @param target a number search as target
     * @return if find out, return target left most index, else return -1
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middleIndex = (left + right) >>> 1;
            int middleValue = nums[middleIndex];

            if (target <= middleValue) {
                if (target == middleValue) {
                    result = middleIndex;
                }

                right = middleIndex - 1;
            } else {
                left = middleIndex + 1;
            }
        }

        return result;
    }
}
