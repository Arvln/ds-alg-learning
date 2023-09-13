class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold=INT_MIN/2, sold=0, cooled=0;
        for (int i=0; i<prices.size(); i++)
        {
            int hold_pre=hold, sold_pre=sold, cooled_pre=cooled;
            hold = max(hold_pre, cooled_pre-prices[i]);
            sold = max({sold_pre, hold_pre+prices[i], cooled_pre});
            cooled = max(sold_pre, cooled_pre);
        }
        return max({hold, sold, cooled});
    }
};

// hold = max { hold_pre, cooled_pre+buy }
// sold = max { sold_pre, hold_pre+sell, cooled_pre }
// cooled = max { sold_pre, cooled_pre }