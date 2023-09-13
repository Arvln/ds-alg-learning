class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n=costs.size();
        vector<vector<int>> dp(n+1, vector<int>(3, 0));

        for (int i=1; i<=n; i++)
        {
            dp[i][0]=min(dp[i-1][1], dp[i-1][2])+costs[i-1][0];
            dp[i][1]=min(dp[i-1][0], dp[i-1][2])+costs[i-1][1];
            dp[i][2]=min(dp[i-1][0], dp[i-1][1])+costs[i-1][2];
        }

        int ret=5000;
        for (int sum : dp[n])
            ret=min(ret, sum);

        return ret;
    }
};