class Solution {
public:
    int findRotateSteps(string ring, string key) {
        int m=ring.size(), n=key.size();
        vector<vector<int>> dp(n, vector<int>(m, 20000));
        unordered_map<char, vector<int>> letterToPos;
        for (int i=0; i<m; i++)
            letterToPos[ring[i]].push_back(i);

        for (int pos : letterToPos[key[0]])
            dp[0][pos]=min(pos, m-pos);

        for (int i=1; i<n; i++)
            for (int cur_pos : letterToPos[key[i]])
                for (int prev_pos : letterToPos[key[i-1]])
                    dp[i][cur_pos]=min(dp[i][cur_pos], dp[i-1][prev_pos]+min(abs(cur_pos-prev_pos), m-abs(cur_pos-prev_pos)));

        int ret=INT_MAX;
        for (int pos : letterToPos[key[n-1]])
            ret=min(ret, dp[n-1][pos]);

        return ret+n;
    }
};