package practices.array.binary_search.s33;

public class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length;

        while (left<right) {
            int mid = left + (right-left)/2;

            if (nums[mid]==target) return mid;
            else if (nums[left]<=nums[mid]) {
                if (nums[left]<=target && target<=nums[mid]) {
                    right=mid;
                } else {
                    left=mid+1;
                }
            } else {
                if (nums[mid]<=target && target<=nums[right-1]) {
                    left=mid+1;
                } else {
                    right=mid;
                }
            }
        }

        return -1;
    }
}
