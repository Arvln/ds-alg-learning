class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int red=0, blue=0, green=0;

        for (int i=0; i<costs.size(); i++)
        {
            int red_pre=red, blue_pre=blue, green_pre=green;
            vector<int> cost=costs[i];
            red = min(blue_pre+cost[1], green_pre+cost[2]);
            blue = min(red_pre+cost[0], green_pre+cost[2]);
            green = min(red_pre+cost[0], blue_pre+cost[1]);
        }
        return min({red, blue, green});
    }
};
// dp[i][j]: 粉刷完所有房子最少的花费成本 ending at num[i] is color j
// dp[i][0] = min(dp[i-1][1], dp[i-1][2]);
// dp[i][1] = min(dp[i-1][0], dp[i-1][2]);
// dp[i][2] = min(dp[i-1][0], dp[i-1][1]);

// red[i] = min(blue[i-1], green[i-1]);
// blue[i] = min(red[i-1], green[i-1]);
// green[i] = min(red[i-1], blue[i-1]);

// red = min(blue_pre, green_pre);
// blue = min(red_pre, green_pre);
// green = min(red_pre, blue_pre);