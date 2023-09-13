class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m=s1.size(), n=s2.size(), k=s3.size();
        if (m+n!=k) return false;
        vector<vector<bool>>dp(m+1, vector<bool>(n+1,false));
        s1="#"+s1, s2="#"+s2, s3="#"+s3;

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

// X X X X X X X X X X X X k

// X X X X X X i
// X X X X X j

// dp[i][j]: s3 是否是由 s1 和 s2 交错 组成的

// if (s1[i]==s3[i+j]&&dp[i-1][j])
//     dp[i][j]=true;
// else if (s2[j]==s3[i+j]&&dp[i][j-1])
//     dp[i][j]=true;