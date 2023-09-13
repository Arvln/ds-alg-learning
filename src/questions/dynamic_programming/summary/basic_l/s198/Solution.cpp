class Solution {
public:
    int rob(vector<int>& nums) {
        int rob=nums[0], norob=0;
        for (int i=1; i<nums.size(); i++)
        {
            int rob_pre=rob, norob_pre=norob;
            rob=max(norob_pre+nums[i], rob_pre);
            norob=max(rob_pre, norob_pre);
        }
        return max(rob, norob);
    }
};

// dp[i][j]: 能够偷窃到的最高金额 at nums[i]
// rob=max(norob_pre+nums[i], rob_pre);
// norob=max(rob_pre, norob_pre);

// max { rob, norob }