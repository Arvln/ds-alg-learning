class Solution {
public:
    int longestPalindromeSubseq(string s) {
        string s1=s, s2=s;
        int n=s1.size();
        reverse(s2.begin(), s2.end());
        s1="#"+s1, s2="#"+s2;
        vector<vector<int>>dp(n+1, vector<int>(n+1,0));

        for (int i=1; i<=n; i++)
            for (int j=1; j<=n; j++)
            {
                if (s1[i]==s2[j])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
            }

        return dp[n][n];

    }
};

// bbaabab
// babaabb

// dp[i][j]: s1[0:i] s2[0:j] 最长的公共子序列

// if (s1[i]==s2[j])
//     dp[i][j]=dp[i-1][j-1]+1;
// else
//     dp[i][j]=max(dp[i-1][j], dp[i][j-1]);