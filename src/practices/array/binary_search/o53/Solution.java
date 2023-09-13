package practices.array.binary_search.o53;

public class Solution {
    public int search1(int[] nums, int target) {
        int left=0, right=0;
        while(right<nums.length && nums[right]<=target) {
            right++;

            while(left<right && nums[left]<target) {
                left++;
            }
        }
        if (left<nums.length && nums[left]==target) return right-left;
        return 0;
    }

    private static int leftBound(int[] nums, int target) {
        int left=0, right=nums.length;
        while(left<right) {
            int mid = left + (right-left)/2;

            if(nums[mid]==target) {
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
        while(left<right) {
            int mid = left + (right-left)/2;

            if(nums[mid]==target) {
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

    public int search(int[] nums, int target) {
        int right=rightBound(nums, target);
        int left=leftBound(nums, target);

        if (right<0 || left<0) return 0;
        return right-left+1;
    }
}
