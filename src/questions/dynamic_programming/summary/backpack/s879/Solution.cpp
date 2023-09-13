class Solution {
    int dp[102][102][102];
public:
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        int m=group.size();
        int M=1e9+7;

        group.insert(group.begin(), 0);
        profit.insert(profit.begin(), 0);
        dp[0][0][0]=1;
        for (int i=0; i<m; i++)
            for (int j=0; j<=n; j++)
                for (int k=0; k<=minProfit; k++)
                {
                    dp[i+1][j][k]+=dp[i][j][k];
                    if (j+group[i+1]<=n)
                        dp[i+1][j+group[i+1]][min(minProfit, k+profit[i+1])]+=dp[i][j][k];

                    dp[i+1][j][k]%=M;
                    if (j+group[i+1]<=n)
                        dp[i+1][j+group[i+1]][min(minProfit, k+profit[i+1])]%=M;
                }

        int ret=0;
        for (int j=0; j<=n; j++)
            ret=(ret+dp[m][j][minProfit])%M;

        return ret;
    }
};

// X X X X X X X X i
//                 {x,y}

// dp[i][person][profit]=dp[i-1][person][profit] + dp[i-1][person-x][profit-y]

// dp[i+1][person][profit]+=dp[i][person][profit]
// dp[i+1][person+x][min(minProfit, profit+y)]+=dp[i][person][profit]

// sum{ dp[m][j][minProfit] } for j=1,2, .. ,n