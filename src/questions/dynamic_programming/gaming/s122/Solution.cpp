class Solution {
public:
    int maxProfit1(vector<int>& prices) {
        int n=prices.size();

        int hold=INT_MIN/2, sold=0;
        for (int i=0; i<n; i++)
        {
            int hold_old=hold, sold_old=sold;
            hold = max(sold_old-prices[i], hold_old);
            sold = max(sold_old, hold_old+prices[i]);
        }
        return sold;
    }
    int maxProfit2(vector<int>& prices) {
        int ret=0;
        for (int i=1; i<prices.size(); i++)
            if (prices[i]>prices[i-1])
                ret+=prices[i]-prices[i-1];

        return ret;
    }
};

// dp[i]: 获取的最大利润
// dp[i][yes] = max{ dp[i-1][no]+buy, dp[i-1][yes] }
// dp[i][no]  = max{ dp[i-1][no], dp[i-1][yes]+sold }

// for (int i=0; i<prices.size(); i++)
//     hold_old=hold, sold_old=sold
//     hold = max{ sold_old+buy, hold_old }
//     sold  = max{ sold_old, hold_old[1]+sold }

// return max(sold[0], sold[1]);