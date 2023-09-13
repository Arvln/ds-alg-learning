package practices.array.binary_search.s162;

public class Solution {
    public int findPeakElement1(int[] nums) {
        int left=0, right=0;
        while (right<nums.length) {
            right++;

            if (right-left==3) {
                int mid = left+1;
                if (nums[left]>nums[mid]) return left;
                else if (nums[mid]>nums[right-1]) return mid;
                left++;
            }
        }
        return nums[right-1]>nums[left] ? right-1 : left;
    }

    public int findPeakElement(int[] nums) {
        int left=0, right=nums.length-1;
        while (left<right) {
            int mid = left + (right-left)/2;

            if (nums[mid]==nums[mid+1]) {
                right=mid;
            } else if (nums[mid]>nums[mid+1]) {
                right=mid;
            } else if (nums[mid]<nums[mid+1]) {
                left=mid+1;
            }
        }

        return left;
    }
}
