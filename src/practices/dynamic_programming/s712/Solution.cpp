class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int m=s1.size(), n=s2.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        s1="#"+s1;
        s2="#"+s2;

        for (int i=1; i<=m; i++)
            dp[i][0]=dp[i-1][0]+(s1[i]-0);
        for (int j=1; j<=n; j++)
            dp[0][j]=dp[0][j-1]+(s2[j]-0);

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (s1[i]==s2[j])
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=min((s1[i]-0)+dp[i-1][j], (s2[j]-0)+dp[i][j-1]);
            }

        return dp[m][n];
    }
};