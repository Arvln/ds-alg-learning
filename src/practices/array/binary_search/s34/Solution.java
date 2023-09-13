package practices.array.binary_search.s34;

public class Solution {
    public int[] windowSearchRange(int[] nums, int target) {
        int left=0, right=0;
        while (right<nums.length && nums[right]<=target) {
            right++;

            while (left<right && nums[left]<target) {
                left++;
            }
        }

        if (left<nums.length && nums[left]==target) return new int[]{left, right-1};

        return new int[]{-1, -1};
    }

    private static int leftBound(int[] nums, int target) {
        int left=0, right=nums.length;
        while (left<right) {
            int mid = left + (right-left)/2;

            if (nums[mid]==target) {
                right=mid;
            } else if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid;
            }
        }

        if (left>=nums.length || nums[left]!=target) return -1;
        return left;
    }

    private static int rightBound(int[] nums, int target) {
        int left=0, right=nums.length;
        while (left<right) {
            int mid = left + (right-left)/2;

            if (nums[mid]==target) {
                left=mid+1;
            } else if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid;
            }
        }

        if (right<1 || nums[right-1]!=target) return -1;
        return right-1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }
}
