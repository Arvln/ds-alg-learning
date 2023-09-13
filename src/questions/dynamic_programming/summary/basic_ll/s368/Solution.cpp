class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n=nums.size();
        vector<int>dp(n, 1);
        vector<int>prev(n, -1);

        int pos=0, len=INT_MIN;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (nums[i]%nums[j]==0)
                {
                    dp[i]=max(dp[i], dp[j]+1);
                    if (dp[i]==dp[j]+1)
                        prev[i]=j;
                }
            }

            if (dp[i]>len)
            {
                len=dp[i];
                pos=i;
            }
        }

        vector<int>ret;
        for(; pos!=-1; pos=prev[pos])
            ret.push_back(nums[pos]);

        return ret;
    }
};

// dp[i]: 其中最大的整除子集 answer元素個數