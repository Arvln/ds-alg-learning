class Solution {
public:
    bool canJump(vector<int>& nums) {
        for (int i=0, step=0; i<nums.size(); i++)
        {
            step=max(step, i+nums[i]);
            if (step<=i) return i==nums.size()-1;
        }
        return true;
    }
};