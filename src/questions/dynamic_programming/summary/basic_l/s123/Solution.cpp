class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<int>hold(2+1, INT_MIN/2);
        vector<int>sold(2+1, INT_MIN/2);

        hold[0]=0, sold[0]=0;

        for (int i=0; i<n; i++)
            for (int j=1; j<=2; j++)
            {
                auto hold_pre=hold, sold_pre=sold;
                hold[j] = max(sold_pre[j-1]-prices[i], hold_pre[j]);
                sold[j] = max(sold_pre[j], hold_pre[j]+prices[i]);
            }

        int ret=INT_MIN/2;
        for (int profit : sold)
            ret=max(ret, profit);
        return ret;
    }
};

// X X X X X i

// dp[i][yes] = max { dp[i-1][no]+buy, dp[i-1][yes] }
// dp[i][no]  = max { dp[i-1][no], dp[i-1][yes]+sell }

// dp[i][yes][j] = max { dp[i-1][no][j-1]+buy, dp[i-1][yes][j] }
// dp[i][no][j]  = max { dp[i-1][no][j], dp[i-1][yes][j]+sell }

// hold[j] = max { sold_pre[j-1]+buy, hold_pre[j] }
// sold[j]  = max { sold_pre[j], hold_pre[j]+sell }

// max { sold[j] } for j=0 .. K