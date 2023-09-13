class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, 20000);
        dp[0]=0;

        for (int i=0; i<=amount; i++)
            for (int coin : coins)
            {
                if (i<coin) continue;
                dp[i]=min(dp[i], 1+dp[i-coin]);
            }

        return dp[amount] == 20000 ? -1 : dp[amount];
    }
};