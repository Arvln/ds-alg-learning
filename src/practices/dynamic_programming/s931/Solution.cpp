class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n=matrix.size();
        vector<vector<int>> dp(n+1, vector<int>(n, 20000));

        for (int j=0; j<n; j++)
            dp[0][j]=0;

        for (int i=1; i<=n; i++)
            for (int j=0; j<n; j++)
            {
                int topLeft=j<1?20000:dp[i-1][j-1];
                int top=dp[i-1][j];
                int topRight=j+1>=n?20000:dp[i-1][j+1];
                dp[i][j]=min({topLeft, top, topRight})+matrix[i-1][j];
            }

        int ret=INT_MAX;
        for (int sum : dp[n])
            ret=min(ret, sum);

        return ret;
    }
};