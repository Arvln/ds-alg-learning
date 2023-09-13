class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        if (k>=n/2)
        {
            int ret=0;
            for (int i=1; i<n; i++)
                if (prices[i]>prices[i-1])
                    ret+=prices[i]-prices[i-1];

            return ret;
        }
        vector<int>hold(k+1, INT_MIN/2);
        vector<int>sold(k+1, INT_MIN/2);

        hold[0]=0;
        sold[0]=0;
        for (int i=0; i<n; i++)
        {
            auto hold_old=hold, sold_old=sold;
            for (int j=1; j<=k; j++)
            {
                hold[j] = max(sold_old[j-1]-prices[i], hold_old[j]);
                sold[j] = max(sold_old[j], hold_old[j]+prices[i]);
            }
        }

        int ret=0;
        for (int profit: sold)
            ret=max(ret, profit);
        return ret;
    }
};

// X X X X X i

// dp[i][yes] = dp[i-1][no]+buy, dp[i-1][yes]
// dp[i][no]  = dp[i-1][no], dp[i-1][yes]+sell

// hold[j] = sold_old[j]+buy, hold_old[j]
// sold[j]  = sold_old[j], hold_old[j-1]+sell

// for (int i=0; i<prices.size(); i++)
// {
//     auto hold_old=hold, sold_old=sold;
//     for (int j=0; j<=k; j++)
//     {
//         hold[j] = max(sold_old[j-1]+buy, hold_old[j]);
//         sold[j]  = max(sold_old[j], hold_old[j]+sell);
//     }
// }

// max {sold[k]} for k = 0 .. K
