class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int n=piles.size();
        vector<vector<int>>dp(n, vector<int>(n));
        for (int i=0; i<n; i++)
            dp[i][i]=0;

        for (int len=2; len<=n; len++)
            for (int i=0; i+len-1<n; i++)
            {
                int j=i+len-1;
                dp[i][j]=max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
            }

        return dp[0][n-1]>0;
    }
};