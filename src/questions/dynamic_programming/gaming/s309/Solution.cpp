class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold=INT_MIN, sold=0, cooled=0;
        for (int i=0; i<prices.size(); i++)
        {
            int hold2=hold, sold2=sold, cooled2=cooled;
            int p=prices[i];

            hold = max(hold2, cooled2-p);
            sold = hold2+p;
            cooled = max(cooled2, sold2);
        }
        return max(sold, cooled);
    }
};

// X X X X X X i

// hold = max(hold, cooled-p);
// sold = hold+p;
// cooled = max(cooled, sold);
