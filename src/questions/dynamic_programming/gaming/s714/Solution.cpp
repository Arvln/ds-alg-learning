class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int hold=INT_MIN, sold=0;
        for (int i=0; i<prices.size(); i++)
        {
            int hold2=hold, sold2=sold;

            hold = max(sold2-prices[i]-fee, hold2);
            sold = max(sold2, hold2+prices[i]);
        }
        return sold;
    }
};

// X X X X X i

// hold = max(sold2-prices[i]-fee, hold2);
// sold = max(sold2, hold2+prices[i]);