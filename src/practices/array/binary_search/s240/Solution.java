package practices.array.binary_search.s240;

public class Solution {
    private int search(int[] nums, int target) {
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
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m=matrix.length, n=m>0 ? matrix[0].length : 0, left=0, right=0;
        while (right<m && matrix[right][0]<=target) {
            if (matrix[right][0]==target) return true;
            right++;

            while (left<right && matrix[left][n-1]<=target) {
                if (matrix[left][n-1]==target) return true;
                left++;
            }
        }
        boolean hasExist = false;
        for (int i = left; i<right; i++) {
            hasExist = hasExist || search(matrix[i], target)>=0;
        }

        return hasExist;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
        while (i<m && j>=0) {
            if (matrix[i][j]==target) return true;
            else if (matrix[i][j]<target) {
                i++;
            } else if (matrix[i][j]>target) {
                j--;
            }
        }

        return false;
    }
}
