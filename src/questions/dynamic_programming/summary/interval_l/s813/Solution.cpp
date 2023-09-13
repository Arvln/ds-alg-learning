class Solution {
public:
    double largestSumOfAverages(vector<int>& nums, int K) {
        int n=nums.size();
        nums.insert(nums.begin(), 0);
        vector<vector<double>>dp(n+1, vector<double>(K+1, INT_MIN/2));
        dp[0][0]=0;

        for (int i=1; i<=n; i++)
            for (int k=1; k<=min(i, K); k++)
            {
                for (int j=i; j>=k; j--)
                    dp[i][k]=max(dp[i][k], dp[j-1][k-1]+helper(nums, j, i));
            }

        return dp[n][K];
    }
    double helper(const vector<int> nums, int a, int b)
    {
        double sum=0, count=0;
        while (a<=b)
        {
            sum+=nums[a];
            count++;
            a++;
        }
        return sum/count;
    }
};

// dp[i][k]: nums[0:i]中k个子数组内的平均值的总和最大

// {X X X X X X X} [j X X i] => max{ dp[j-1][k-1] + helper(nums[j:i]) } for j=1 .. i

// dp[n][K]