class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int m=s1.size(), n=s2.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 300000));

        s1="#"+s1;
        s2="#"+s2;

        int sum1=0, sum2=0;
        dp[0][0]=0;
        for (int i=1; i<=m; i++)
        {
            sum1+=(s1[i]-0);
            dp[i][0]=sum1;
        }
        for (int j=1; j<=n; j++)
        {
            sum2+=(s2[j]-0);
            dp[0][j]=sum2;
        }


        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (s1[i]==s2[j])
                    dp[i][j]=min(dp[i][j], dp[i-1][j-1]);

                dp[i][j]=min(dp[i][j], (s1[i]-0)+dp[i-1][j]);
                dp[i][j]=min(dp[i][j], (s2[j]-0)+dp[i][j-1]);
            }

        return dp[m][n];
    }
};