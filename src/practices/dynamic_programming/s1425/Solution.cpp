class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        int n=nums.size();
        vector<int> dp(n, INT_MIN);
        deque<pair<int, int>> dq;
        dq.push_back({nums[0], 0});

        int ret=nums[0];
        for (int i=1; i<n; i++)
        {
            if (!dq.empty() && i-dq.front().second>k)
                dq.pop_front();

            dp[i]=max(nums[i], dq.front().first+nums[i]);
            ret=max(ret, dp[i]);
            while (!dq.empty() && dq.back().first<dp[i])
                dq.pop_back();
            dq.push_back({dp[i], i});
        }
        return ret;
    }
};