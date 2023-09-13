package binary_search.questions;

public class Q3 {
    private static int getRightMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middleIndex = (left + right) >>> 1;
            int middleValue = nums[middleIndex];

            if (target < middleValue){
                right = middleIndex - 1;
            } else {
                if (target == middleValue) {
                    result = middleIndex;
                }

                left = middleIndex + 1;
            }
        }

        return result;
    }

    private static int getLeftMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int middleIndex = (left + right) >>> 1;
            int middleValue = nums[middleIndex];

            if (target <= middleValue){
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

    public static int[] getInterval(int[] nums, int target) {
        int[] result = {-1, -1};

        int leftMostIndex = getLeftMostIndex(nums, target);

        if (leftMostIndex != -1) {
            result[0] = leftMostIndex;
            result[1] = getRightMostIndex(nums, target);
        }

        return result;
    }
}
