package practices.array.binary_search.s704;

public class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length;
        while (left<right) {
            int mid = left + (right-left)/2;
            
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]<target) {
                left=mid+1;
            } else if (nums[mid]>target) {
                right=mid;
            }
        }

        return -1;
    }
}
