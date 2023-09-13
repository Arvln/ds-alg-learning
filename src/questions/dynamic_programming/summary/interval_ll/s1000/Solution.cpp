class Solution {
public:
    int mergeStones(vector<int>& stones, int K) {
        int n=stones.size();
        if ((n-1)%(K-1)) return -1;
        vector<vector<vector<int>>>dp(n, vector<vector<int>>(n, vector<int>(K+1, INT_MAX)));

        for (int i=0; i<n; i++)
            dp[i][i][1]=0;

        vector<int>sum(n+1, 0);
        for (int i=0; i<n; i++)
            sum[i+1]=sum[i]+stones[i];

        for (int len=2; len<=n; len++)
            for (int i=0; i+len-1<n; i++)
            {
                int j=i+len-1;
                for (int k=2; k<=min(len, K); k++)
                    for (int m=j; m>i; m--)
                    {
                        if (dp[i][m-1][k-1]==INT_MAX||dp[m][j][1]==INT_MAX) continue;
                        dp[i][j][k]=min(dp[i][j][k], dp[i][m-1][k-1]+dp[m][j][1]);
                    }

                if (dp[i][j][K]!=INT_MAX)
                    dp[i][j][1]=dp[i][j][K]+sum[j+1]-sum[i];
            }

        return dp[0][n-1][1];
    }
};

// i X X X X X X X [m X X j]

// dp[i][j][k]: stones[i:j]合并成k堆的最低成本

// dp[i][j][k] = min{ dp[i][m-1][k-1] + dp[m][j][1] } for m=i .. j
// dp[i][j][1] = dp[i][j][k]+sum[i:j]