class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<int>dp(n, 1);

        int ret=INT_MIN;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<i; j++)
                if (nums[j]<nums[i])
                    dp[i]=max(dp[i], dp[j]+1);

            ret=max(ret, dp[i]);
        }

        return ret;
    }
};

// dp[i]: 其中最长严格递增子序列的长度 ending at nums[i]