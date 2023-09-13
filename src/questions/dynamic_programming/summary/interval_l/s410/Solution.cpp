class Solution {
public:
    int splitArray(vector<int>& nums, int K) {
        int n=nums.size();
        nums.insert(nums.begin(), 0);
        vector<vector<int>>dp(n+1, vector<int>(K+1, INT_MAX/2));
        dp[0][0]=0;

        vector<int>preSum(n+2, 0);
        for (int i=1; i<=n; i++)
            preSum[i+1]=preSum[i]+nums[i];

        for (int i=1; i<=n; i++)
            for (int k=1; k<=min(i, K); k++)
            {
                for (int j=i; j>=k; j--)
                    dp[i][k]=min(dp[i][k], max(dp[j-1][k-1], preSum[i+1]-preSum[j]));
            }

        return dp[n][K];
    }
};

// dp[i][k]: s[0:i] 分成 k 个子数组各自和的最大值最小

// X X X X X X [j X X i] => min {max{ dp[j-1][k-1], sum(nums[j:i]) }} for j=1 .. i