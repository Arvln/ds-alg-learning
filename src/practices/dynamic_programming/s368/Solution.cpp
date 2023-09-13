class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> dp(n, vector<int>());

        for (int i=0; i<n; i++)
        {
            dp[i].push_back(nums[i]);
            int maxLen=0;
            for (int j=0; j<i; j++)
            {
                int prev=dp[j].back(), cur=nums[i];
                if (cur%prev==0&&maxLen<dp[j].size())
                {
                    maxLen=dp[j].size();
                    dp[i]=dp[j];
                    dp[i].push_back(cur);
                }
            }
        }
        vector<int> ret;
        for (vector<int> v : dp){
            if (v.size()>ret.size())
                ret=v;
        }
        return ret;
    }
};