class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        int m=str1.size(), n=str2.size();
        vector<vector<int>>dp(m+1, vector<int>(n+1, 0));
        str1="#"+str1, str2="#"+str2;

        for (int i=1; i<=m; i++)
            dp[i][0]=i;
        for (int j=1; j<=n; j++)
            dp[0][j]=j;

        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
            {
                if (str1[i]==str2[j])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1);
            }

        int i=m, j=n;
        string ret;
        while(i>0&&j>0)
        {
            if (str1[i]==str2[j])
            {
                ret.push_back(str1[i]);
                i--, j--;
            } else if (dp[i][j]==dp[i-1][j]+1)
            {
                ret.push_back(str1[i]);
                i--;
            } else {
                ret.push_back(str2[j]);
                j--;
            }
        }
        while (i>0)
        {
            ret.push_back(str1[i]);
            i--;
        }
        while (j>0)
        {
            ret.push_back(str2[j]);
            j--;
        }

        reverse(ret.begin(), ret.end());
        return ret;
    }
};

// dp[i][j]: 同时以 str1 和 str2 作为 子序列 的最短字符串長度
// X X X X X X i
// X X X X X j
// if (str1[i]==str2[j])
//     dp[i][j]=dp[i-1][j-1]+1;
// else
//     dp[i][j]=min(dp[i-1][j]+1, dp[i][j-1]+1);