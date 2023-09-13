class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();

        int hold=INT_MIN/2, sold=0;
        for (int i=0; i<n; i++)
        {
            int hold_old=hold, sold_old=sold;
            hold = max(-prices[i], hold_old);
            sold = max(sold_old, hold_old+prices[i]);
        }
        return sold;
    }
};

// dp[i]: 获取的最大利润
// dp[i][yes] = max{ dp[i-1][no]+buy, dp[i-1][yes] }
// dp[i][no]  = max{ dp[i-1][no], dp[i-1][yes]+sold }

// for (int i=0; i<prices.size(); i++)
//     hold_old=hold, sold_old=sold
//     hold = max{ 0+buy, hold_old }
//     sold  = max{ sold_old, hold_old+sold }

// return sold;