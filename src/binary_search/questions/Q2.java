package binary_search.questions;

public class Q2 {
    /**
     *
     * @param nums an order array
     * @param target search target number
     * @param left left bound
     * @param right right bound
     * @param result if find out return right most index, else return insert point
     * @return if find out return left most index, else return insert point
     */
    private static int searchHelper(int[] nums, int target, int left, int right, int result) {
        if (left > right) return result;

        int middleIndex = (left + right) >>> 1;
        int middleValue = nums[middleIndex];

        if (target <= middleValue) {
            return searchHelper(nums, target, left, middleIndex - 1, left);
        } else {
            left = middleIndex + 1;
            return searchHelper(nums, target, left, right, left);
        }
    }
    /**
     *
     * @param nums an order array
     * @param target search target number
     * @return if find out return right most index, else return insert point
     */
    public static int getInsertPoint(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1, 0);
    }
}
