class Solution {
public:
    int rob(vector<int>& nums) {
        int rob=nums[0], norob=0;
        for (int i=1; i<nums.size(); i++)
        {
            int rob_tmp=rob;
            rob=norob+nums[i];
            norob=max(rob_tmp, norob);
        }
        return max(rob, norob);
    }
};