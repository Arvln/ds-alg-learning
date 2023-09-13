class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        int m=dungeon.size(), n=dungeon[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));

        for (int i=m-1; i>=0; i--)
            for (int j=n-1; j>=0; j--)
            {
                if (i==m-1&&j==n-1)
                    dp[i][j]=1;
                else if (i==m-1)
                    dp[i][j]=dp[i][j+1]-dungeon[i][j+1];
                else if (j==n-1)
                    dp[i][j]=dp[i+1][j]-dungeon[i+1][j];
                else
                    dp[i][j]= min(dp[i+1][j]-dungeon[i+1][j], dp[i][j+1]-dungeon[i][j+1]);
                dp[i][j]=max(dp[i][j], 1);
            }

        dp[0][0]-=dungeon[0][0];
        dp[0][0]=max(dp[0][0], 1);
        return dp[0][0];
    }
};