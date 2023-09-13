class Solution {
    vector<int> memo;
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int ret=INT_MAX;
        memo=vector<int>(1<<14, INT_MIN);

        for (int j=0; j<n; j++)
            ret=min(ret, dp(matrix, n-1, j));
        return ret;
    }
    int dp(vector<vector<int>>& matrix, int i, int j)
    {
        if (i<0) return 0;
        if (j<0||j>=matrix.size()) return INT_MAX;
        int state=(i<<7)+j;
        if (memo[state]!=INT_MIN) return memo[state];

        memo[state]=matrix[i][j]+min(
            dp(matrix, i-1, j-1),
            min(
                dp(matrix, i-1, j),
                dp(matrix, i-1, j+1)
            )
        );

        return memo[state];
    }
};
