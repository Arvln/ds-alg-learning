package practices.array.prev_sum.s1314;

public class Solution {
    private static class NumMatrix {
        private static int[][] preMatrix;

        public NumMatrix(int[][] matrix) {
            int m=matrix.length, n=matrix[0].length;
            preMatrix=new int[m+1][n+1];

            for(int i=1; i<=m; i++) {
                for(int j=1; j<=n; j++) {
                    preMatrix[i][j]=preMatrix[i-1][j]+preMatrix[i][j-1]+matrix[i-1][j-1]-preMatrix[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1++;
            col1++;
            row2++;
            col2++;
            return preMatrix[row2][col2]-preMatrix[row1-1][col2]-preMatrix[row2][col1-1]+preMatrix[row1-1][col1-1];
        }
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length, n=mat[0].length;
        int[][] res=new int[m][n];
        NumMatrix numMatrix = new NumMatrix(mat);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1=Math.max(i-k, 0);
                int c1=Math.max(j-k, 0);
                int r2=Math.min(i+k, m-1);
                int c2=Math.min(j+k, n-1);

                res[i][j] = numMatrix.sumRegion(r1, c1, r2, c2);
            }
        }

        return res;
    }
}
