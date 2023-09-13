package questions.array.s304;

public class NumMatrix {
    private int[][] prevMatrix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = (m == 0) ? 0 : matrix[0].length;

        if (m == 0 || n == 0) return;

        prevMatrix = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prevMatrix[i][j] =
                        prevMatrix[i-1][j]
                        + prevMatrix[i][j-1]
                        + matrix[i-1][j-1]
                        - prevMatrix[i-1][j-1];

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;row2++;col1++;col2++;
        return prevMatrix[row2][col2]
                - prevMatrix[row2][col1-1]
                - prevMatrix[row1-1][col2]
                + prevMatrix[row1-1][col1-1];
    }
}
