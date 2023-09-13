class Solution {
public:
    int maximumSum(vector<int>& arr) {
        int n=arr.size();
        vector<vector<int>>dp(n+1, vector<int>(2, 0));
        arr.insert(arr.begin(), 0);

        for (int i=1; i<=n; i++)
        {
            dp[i][0]=max(dp[i-1][0]+arr[i], arr[i]);
            dp[i][1]=max(dp[i-1][0], dp[i-1][1]+arr[i]);
        }
        int ret=INT_MIN;
        for (int i=1; i<=n; i++)
            ret=max(ret, dp[i][0]);
        for (int i=2; i<=n; i++)
            ret=max(ret, dp[i][1]);

        return ret;
    }
};

// dp[i][j]: 某个 非空 子数组（连续元素）在执行j次可选的删除操作后，所能得到的最大元素总和 ending at arr[i]

// X X X X X i
// dp[i][0]=max(dp[i-1][0]+arr[i], arr[i]);
// dp[i][1]=max(dp[i-1][0], dp[i-1][1]+arr[i]);