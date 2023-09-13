class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for (int num : nums)
            sum+=num;
        if (sum%2!=0) return false;
        sum=sum/2;
        int n=nums.size();
        vector<vector<bool>> dp(n+1, vector<bool>(sum+1, false));
        nums.insert(nums.begin(), 0);
        for (int i=1; i<=n; i++)
            dp[i][0]=true;
        for (int i=1; i<=n; i++)
            for (int w=1; w<=sum; w++)
            {
                if (w>=nums[i])
                    dp[i][w]=dp[i-1][w]||dp[i-1][w-nums[i]];
                else
                    dp[i][w]=dp[i-1][w];
            }

        return dp[n][sum];
    }
};