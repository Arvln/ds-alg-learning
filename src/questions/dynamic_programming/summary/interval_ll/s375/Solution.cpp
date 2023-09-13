class Solution {
public:
    int getMoneyAmount(int n) {
        vector<vector<int>>dp(n+2, vector<int>(n+2, 0));

        for (int len=2; len<=n; len++)
            for (int i=1; i+len-1<=n; i++)
            {
                int j=i+len-1;
                dp[i][j]=INT_MAX;
                for (int k=i; k<=j; k++)
                    dp[i][j]=min(dp[i][j], k+max(dp[i][k-1], dp[k+1][j]));
            }

        return dp[1][n];
    }
};

// 1 2 3 4 5
// 1 -> 1 + max([1,0], [2,3,4,5])
// 2 -> 2 + max([1], [3,4,5])
// 3 -> 3 + max([1,2], [4,5])
// 4 -> 4 + max([1,2,3], [5])
// 5 -> 5 + max([2,3,4,5], [6,5])

// dp[i][j]: [i:j] 确保获胜 的最小现金数