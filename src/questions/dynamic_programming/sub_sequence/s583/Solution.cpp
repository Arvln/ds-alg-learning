class Solution {
public:
    int minDistance(string word1, string word2) {
        int m=word1.size(), n=word2.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 2000));
        word1.insert(word1.begin(), '#');
        word2.insert(word2.begin(), '#');

        for (int i=0; i<=m; i++)
            dp[i][0]=i;
        for (int j=0; j<=n; j++)
            dp[0][j]=j;

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (word1[i]==word2[j])
                    dp[i][j]=min(dp[i][j], dp[i-1][j-1]);

                dp[i][j]=min(dp[i][j], 1+dp[i-1][j]);
                dp[i][j]=min(dp[i][j], 1+dp[i][j-1]);
            }

        return dp[m][n];
    }
};
