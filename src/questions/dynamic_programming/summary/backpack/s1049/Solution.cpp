class Solution {
    unordered_map<int, int> memo;
public:
    int lastStoneWeightII1(vector<int>& stones) {
        return backtrack(stones, 0, 0);
    }
    int backtrack(vector<int>& stones, int weight, int i)
    {
        if (abs(weight)>=200) return INT_MAX;
        if (i==stones.size())
            return abs(weight);
        int state=(i<<12)+weight+3000;
        if (memo.find(state)!=memo.end())
            return memo[state];

        memo[state]=min(backtrack(stones, weight+stones[i], i+1),
        backtrack(stones, weight-stones[i], i+1));
        return memo[state];
    }

    int lastStoneWeightII2(vector<int>& stones) {
        int n=stones.size();
        stones.insert(stones.begin(), 0);
        vector<vector<bool>>dp(31, vector<bool>(401,false));
        int offset=200;
        dp[0][0+offset]=true;
        for (int i=1; i<=n; i++)
            for (int s=-offset; s<=offset; s++)
            {
                if (s-stones[i]>=-offset)
                {
                    s+=offset;
                    dp[i][s] = dp[i][s] || dp[i-1][s-stones[i]];
                    s-=offset;
                }

                if (s+stones[i]<=offset)
                {
                    s+=offset;
                    dp[i][s] = dp[i][s] || dp[i-1][s+stones[i]];
                    s-=offset;
                }
            }

        for (int i=offset; i<=2*offset; i++)
            if (dp[n][i])
                return i-offset;

        return -1;
    }
};

// ret = +/-a, +/-b, +/-c, ...
// min { abs(ret) }
