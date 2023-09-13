class Solution {
    int mod = 1e9 + 7;
public:
    int numDistinct(string s, string t) {
        int m=s.size(), n=t.size();
        vector<vector<int>>dp(m+1, vector<int>(n+1, 0));
        s="#"+s, t="#"+t;

        for (int i=0; i<=m; i++)
            dp[i][0]=1;

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (s[i]==t[j])
                    dp[i][j]+=dp[i-1][j-1];
                dp[i][j]+=dp[i-1][j];
                if(dp[i][j] >= mod)
                    dp[i][j]%=mod;
            }

        return dp[m][n];
    }
};

// X X X X X X i
// X X X X X j

// dp[i][j]: s[0:i] t[0:j]出现的个数

// if (s[i]==t[j])
//     dp[i][j]+=dp[i-1][j-1];
// dp[i][j]+=dp[i-1][j];