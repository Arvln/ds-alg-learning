using AI3=array<int, 3>;
class Solution {
public:
    int findCheapestPriceDijkstra(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int, int>>>next(n);
        for (vector<int> flight : flights)
        {
            int a=flight[0], b=flight[1], p=flight[2];
            next[a].push_back({b, p});
        }
        vector<int>cost(n, INT_MAX);
        vector<int>time(n, INT_MAX);
        cost[src]=time[src]=0;
        priority_queue<AI3, vector<AI3>, greater<>>pq;// {cost, city, times}
        pq.push({0, src, 0});
        while (!pq.empty())
        {
            auto [c, cur, times] = pq.top();
            pq.pop();

            if (cur==dst) return c;
            if (times>k) continue;

            for (auto[nxt, price] : next[cur])
            {
                int next_price=c+price;
                int next_time=times+1;
                if (cost[nxt]>next_price)
                {
                    cost[nxt]=next_price;
                    time[nxt]=next_time;
                }
                if (next_price>cost[nxt]&&next_time>time[nxt]) continue;
                pq.push({next_price, nxt, next_time});
            }
        }
        return -1;
    }
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<int>> dp(k+2, vector<int>(n, INT_MAX/2));
        dp[0][src]=0;

        int ret=INT_MAX/2;
        for (int i=1; i<=k+1; i++)
            for (auto flight : flights)
            {
                int a=flight[0], b=flight[1], p=flight[2];
                dp[i][b]=min(dp[i][b], dp[i-1][a]+p);
                if (b==dst) ret=min(ret, dp[i][b]);
            }

        return ret==INT_MAX/2 ? -1 : ret;
    }
};