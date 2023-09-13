class Solution {
public:
    int minInsertions(string s) {
        string s1=s, s2=s;
        int n=s1.size();
        reverse(s2.begin(), s2.end());
        vector<vector<int>>dp(n+1, vector<int>(n+1,0));
        s1="#"+s1, s2="#"+s2;

        for (int i=1; i<=n; i++)
            dp[i][0]=i, dp[0][i]=i;
        for (int i=1; i<=n; i++)
            for (int j=1; j<=n; j++)
            {
                if (s1[i]==s2[j])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1);
            }

        return dp[n][n]-n;
    }
};

// mbadm
// mdabm
// mdbabdm

// dp[i][j]: s1[0:i] s2[0:j] 最短公共超級序列

// if (s1[i]==s2[j])
//     dp[i][j]=dp[i-1][j-1]+1;
// else
//     dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1);