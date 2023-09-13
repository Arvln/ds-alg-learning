class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n=nums.size(), ret=INT_MIN, cur=0;
        nums.insert(nums.begin(), 0);
        for (int i=1; i<=n; i++)
        {
            cur=max(nums[i], nums[i]+cur);
            ret=max(ret, cur);
        }
        return ret;
    }
};