package questions.array.s59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int left=0, right=n-1, top=0, bottom=n-1, count=1;
        while (count<=n*n) {
            if (top<=bottom) {
                for (int i = left; i <= right; i++) {
                    result[top][i] = count;
                    count++;
                }
                top++;
            }

            if (left<=right) {
                for (int i = top; i <= bottom; i++) {
                    result[i][right] = count;
                    count++;
                }
                right--;
            }

            if (top<=bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = count;
                    count++;
                }
                bottom--;
            }

            if (left<=right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = count;
                    count++;
                }
                left++;
            }
        }

        return result;
    }
}
