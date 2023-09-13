class Solution {
public:
    int tallestBillboard(vector<int>& rods) {
        int offset=5000;
        vector<int>dp(2*offset+1, -1);

        dp[0+offset]=0;
        for (int i=0; i<rods.size(); i++)
        {
            int l=rods[i];
            auto old_dp=dp;
            for (int diff=-offset; diff<=offset; diff++)
            {
                if (old_dp[diff+offset]==-1) continue;

                if (diff+l<=offset)
                    dp[diff+l+offset]=max(dp[diff+l+offset], old_dp[diff+offset]+l);
                if (diff-l>=-offset)
                    dp[diff-l+offset]=max(dp[diff-l+offset], old_dp[diff+offset]);
            }
        }

        return dp[0+offset];
    }
};

// dp[diff] maxmium of left when diff==left-right
// dp[diff+l]=max(dp[diff+l], old_dp[diff]+l)
// dp[diff-l]=max(dp[diff-l], old_dp[diff])