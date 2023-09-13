class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m=s1.size(), n=s2.size();
        if ((m+n)!=s3.size()) return false;
        vector<vector<bool>> dp(m+1, vector<bool>(n+1, false));
        s1="#"+s1;
        s2="#"+s2;
        s3="#"+s3;

        dp[0][0]=true;
        for (int i=1; i<=m; i++)
            dp[i][0]=s1[i]==s3[i]&&dp[i-1][0];
        for (int j=1; j<=n; j++)
            dp[0][j]=s2[j]==s3[j]&&dp[0][j-1];

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (s1[i]==s3[i+j]&&dp[i-1][j])
                    dp[i][j]=true;
                else if (s2[j]==s3[i+j]&&dp[i][j-1])
                    dp[i][j]=true;
            }

        return dp[m][n];
    }
};