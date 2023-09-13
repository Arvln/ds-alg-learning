package questions.array.s54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length, n = matrix[0].length;
        int left=0, right=n-1, top=0, bottom=m-1;

        while (result.size() < m*n) {
            if (top<=bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            }

            if (left<=right) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            
            if (top<=bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left<=right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
