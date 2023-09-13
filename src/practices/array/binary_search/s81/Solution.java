package practices.array.binary_search.s81;

public class Solution {
    public static boolean search(int[] nums, int target) {
        int left=0, right=nums.length;
        while(left<right) {
            int mid=left+(right-left)/2;

            if (nums[mid]==target) return true;
            else if (nums[left]==nums[mid]) left++;
            else if (nums[mid]==nums[right-1]) right--;
            else if (nums[left]<nums[mid]) {
                if (nums[left]<=target && target<=nums[mid]) {
                    right=mid;
                } else {
                    left=mid+1;
                }
            }
            else {
                if (nums[mid]<=target && target<=nums[right-1]) {
                    left=mid+1;
                } else {
                    right=mid;
                }
            }
        }

        return false;
    }
}
