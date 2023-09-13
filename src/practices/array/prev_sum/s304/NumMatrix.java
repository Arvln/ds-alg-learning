package practices.array.prev_sum.s304;

public class NumMatrix {
    private int[][] prevSum;

    public NumMatrix(int[][] matrix) {
        int m=matrix.length, n = (m == 0) ? 0 : matrix[0].length;

        if (m==0 || n==0) return;
        prevSum = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prevSum[i][j]=prevSum[i-1][j]+prevSum[i][j-1]+matrix[i-1][j-1]-prevSum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return prevSum[row2][col2]-prevSum[row2][col1-1]-prevSum[row1-1][col2]+prevSum[row1-1][col1-1];
    }
}
