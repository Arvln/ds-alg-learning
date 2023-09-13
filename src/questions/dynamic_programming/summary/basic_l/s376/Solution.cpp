class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        int pos=1, neg=1;
        for (int i=1; i<nums.size(); i++)
        {
            int pos_pre=pos, neg_pre=neg;
            if (nums[i]==nums[i-1])
                continue;
            else if (nums[i]>nums[i-1])
                pos = max(1+neg_pre, pos_pre);
            else
                neg = max(1+pos_pre, neg_pre);
        }
        return max(pos, neg);
    }
};

// dp[i][j]: nums 中作为 摆动序列 的 最长子序列的长度 ending at nums[i]
// dp[i][pos] = max(1+dp[i-1][neg], dp[i-1][pos]);
// dp[i][neg] = max(1+dp[i-1][pos], dp[i-1][neg]);
// pos = max(1+neg_pre, pos_pre);
// neg = max(1+pos_pre, neg_pre);