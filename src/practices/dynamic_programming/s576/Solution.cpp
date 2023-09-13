class Solution {
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int M=1e9+7;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> tmp=dp;

        for (; maxMove>0; maxMove--)
        {
            for (int i=0; i<m; i++)
                for (int j=0; j<n; j++)
                {
                    long ret=0;
                    ret+=(i<1) ? 1 : dp[i-1][j];
                    ret+=(j<1) ? 1 : dp[i][j-1];
                    ret+=(i+1>=m) ? 1 : dp[i+1][j];
                    ret+=(j+1>=n) ? 1 : dp[i][j+1];

                    tmp[i][j]=ret%M;
                }
            dp=tmp;
        }
        return dp[startRow][startColumn];
    }
};