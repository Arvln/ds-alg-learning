class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m=text1.size(), n=text2.size();
        vector<vector<int>>dp(m+1, vector<int>(n+1, 0));
        text1="#"+text1, text2="#"+text2;

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (text1[i]==text2[j])
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
            }

        return dp[m][n];
    }
};

// dp[i][j]: 两个字符串的最长 公共子序列 的长度

// if (text1[i]==text2[j])
//     dp[i][j]=1+dp[i-1][j-1];
// else
//     dp[i][j]=max(dp[i-1][j], dp[i][j-1]);