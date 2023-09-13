class Solution {
    int dp[602][102][102];
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        int N=strs.size();
        strs.insert(strs.begin(), "");

        for (int i=1; i<=N; i++)
        {
            int zeros=0, ones=0;
            for (char c : strs[i])
            {
                if (c=='0') zeros+=1;
                else ones+=1;
            }

            for (int j=0; j<=m; j++)
                for (int k=0; k<=n; k++)
                {
                   dp[i][j][k]=max(dp[i][j][k], dp[i-1][j][k]);

                   if (j>=zeros&&k>=ones)
                       dp[i][j][k]=max(dp[i][j][k], dp[i-1][j-zeros][k-ones]+1);
                }
        }

        return dp[N][m][n];
    }
};

// X X X X X i
//           {x, y}

// dp[i][j][k]=max{ dp[i-1][zeros][ones], dp[i-1][j-x][k-y]+1 }

// dp[N][m][n]