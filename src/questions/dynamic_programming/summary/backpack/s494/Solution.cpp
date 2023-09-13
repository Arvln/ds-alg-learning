class Solution {
    int dp[21][2001];
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int n=nums.size();
        nums.insert(nums.begin(), 0);

        int offset=1000;
        dp[0][0+offset]=1;
        for (int i=1; i<=n; i++)
            for (int s=-1000; s<=1000; s++)
            {
                if (s-nums[i]>=-1000)
                    dp[i][s+offset] += dp[i-1][s-nums[i]+offset];
                if (s+nums[i]<=1000)
                    dp[i][s+offset] += dp[i-1][s+nums[i]+offset];
            }

        return dp[n][target+offset];
    }
};

// X X X X X X i

// dp[i][s] = dp[i-1][s-nums[i]] + dp[i-1][s+nums[i]]