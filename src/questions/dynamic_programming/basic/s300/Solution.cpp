class Solution {
public:
    int lengthOfLIS1(vector<int>& nums) {
        int N=nums.size();
        vector<int> dp(N, 1);

        int ret=0;
        for (int i=0; i<N; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (nums[j]<nums[i])
                    dp[i]=max(dp[i], 1+dp[j]);
            }
            ret=max(ret, dp[i]);
        }

        return ret;
    }
    int lengthOfLIS2(vector<int>& nums) {
        int N=nums.size();
        vector<int> q;
        for (int num : nums)
        {
            if (q.empty() || q.back()<num)
                q.push_back(num);
            else
            {
                auto iter=lower_bound(q.begin(), q.end(), num);
                *iter=num;
            }
        }

        return q.size();
    }
};
