class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int n=nums.size(), sum=0;
        for (int num : nums) sum+=num;
        if (sum%2!=0) return false;
        sum/=2;
        vector<vector<bool>>dp(n+1, vector<bool>(sum+1, false));
        nums.insert(nums.begin(), 0);
        dp[0][0]=true;

        for (int i=1; i<=n; i++)
            for (int j=0; j<=sum; j++)
                if (j>=nums[i])
                    dp[i][j]=dp[i-1][j-nums[i]]||dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];

        return dp[n][sum];
    }
};