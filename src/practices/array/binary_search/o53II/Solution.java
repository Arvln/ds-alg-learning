package practices.array.binary_search.o53II;

public class Solution {
    public int missingNumber(int[] nums) {
        int left=0, right=nums.length;
        while(left<right) {
            int mid=left+(right-left)/2;

            if (nums[mid]==mid) {
                left=mid+1;
            } else if (nums[mid]>mid) {
                right=mid;
            }
        }
        return left;
    }
}
