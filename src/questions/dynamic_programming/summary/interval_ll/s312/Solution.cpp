class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int n=nums.size();
        nums.insert(nums.begin(), 1);
        nums.push_back(1);
        vector<vector<int>>dp(n+2, vector<int>(n+2, 0));

        for (int len=1; len<=n; len++)
            for (int i=1; i+len-1<=n; i++)
            {
                int j=i+len-1;

                for (int k=i; k<=j; k++)
                    dp[i][j]=max(dp[i][j], dp[i][k-1]+dp[k+1][j]+nums[k]*nums[i-1]*nums[j+1]);
            }

        return dp[1][n];
    }
};

// i X X X X [k] X X X X j

// dp[i][j]: nums[i:j]获得硬币的最大数量

// dp[i][j]= max{ dp[i][k-1]+dp[k+1][j]+nums[k]*nums[i-1]*nums[j+1] } for k=i .. j