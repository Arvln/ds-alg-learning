class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<int>hold(2+1, INT_MIN/2);
        vector<int>sold(2+1, INT_MIN/2);

        sold[0]=0;
        for (int i=0; i<prices.size(); i++)
        {
            auto hold_old=hold, sold_old=sold;

            for(int k=1; k<=2; k++)
            {
                hold[k] = max(sold_old[k-1]-prices[i], hold_old[k]);
                sold[k] = max(sold_old[k], hold_old[k]+prices[i]);
            }
        }

        int ret=0;
        for (int profit : sold)
            ret=max(ret, profit);
        return ret;
    }
};

// X X X X X i

// dp[i][yes][k] = dp[i-1][no][k-1]+buy, dp[i-1][yes][k]
// dp[i][no][k]  = dp[i-1][no][k], dp[i-1][yes][k]+sell

// for (int i=0; i<prices.size(); i++)
//     hold_old=hold, sold_old=sold;

//     for(int k=0; k<=2; k++)
//         hold[[k] = max(sold_old[k-1]+buy, hold_old[k]);
//         sold[k]  = max(sold_old[k], hold_old[k]+sell);

// max { sold[j] } for j=1 .. k