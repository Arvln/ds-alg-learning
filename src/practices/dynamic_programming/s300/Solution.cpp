class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int m=nums.size();
        vector<int> ret;
        ret.push_back(nums[0]);
        for (int i=1; i<m; i++)
        {
            if (nums[i]>ret.back())
                ret.push_back(nums[i]);
            else
            {
                auto iter=lower_bound(ret.begin(), ret.end(), nums[i]);
                *iter=nums[i];
            }
        }

        return ret.size();
    }
};