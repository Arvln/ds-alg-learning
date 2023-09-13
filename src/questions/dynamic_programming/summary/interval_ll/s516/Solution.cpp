class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n=s.size();
        vector<vector<int>>dp(n+1, vector<int>(n+1, 0));
        s="#"+s;
        for (int i=1; i<=n; i++)
            dp[i][i]=1;

        for (int len=2; len<=n; len++)
            for (int i=1; i+len-1<=n; i++)
            {
                int j=i+len-1;

                if (s[i]==s[j])
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=max(dp[i][j-1], dp[i+1][j]);
            }

        return dp[1][n];
    }
};

// X X X X X X X j X X i

// dp[i][j]: 最长的回文子序列长度

// if (s[i]==s[j])
//     dp[i][j]=dp[i+1][j-1]+2;
// else
//     dp[i][j]=max(dp[i][j-1], dp[i+1][j]);