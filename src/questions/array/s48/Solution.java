package questions.array.s48;

public class Solution {
    private static void reverse(int[] nums) {
        int left=0, right=nums.length-1;
        while (left<right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private int[][] nRotate(int n, int[][] matrix) {
        n %= 4;
        if (n == 0) return matrix;
        else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }

            for (int[] row : matrix) {
                reverse(row);
            }

            return nRotate(n-1, matrix);
        }
    }

    private void antiRotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int t = 0;
            for (int j = matrix.length-1-i; j >= 0; j--,t++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i+t][j+t];
                matrix[i+t][j+t] = tmp;
            }
        }

        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public void rotate(int[][] matrix) {
        nRotate(1, matrix);
    }
}
