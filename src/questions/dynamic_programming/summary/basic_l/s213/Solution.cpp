class Solution {
public:
    int rob(vector<int>& nums) {
        int rob=nums[0], norob=0;
        for (int i=1; i<nums.size()-1; i++)
        {
            int rob_pre=rob, norob_pre=norob;
            rob=max(norob_pre+nums[i], rob_pre);
            norob=max(rob_pre, norob_pre);
        }

        int ret=max(rob, norob);
        rob=norob=0;
        for (int i=1; i<nums.size(); i++)
        {
            int rob_pre=rob, norob_pre=norob;
            rob=max(norob_pre+nums[i], rob_pre);
            norob=max(rob_pre, norob_pre);
        }

        return max({ret, rob, norob});
    }
};

// [   ] N
// N [   ]