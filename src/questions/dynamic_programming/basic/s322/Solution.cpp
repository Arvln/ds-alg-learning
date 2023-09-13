class Solution {
    vector<int> memo;
public:
    int coinChange1(vector<int>& coins, int amount) {
        memo=vector(amount+1, -67);
        return dfs(coins, amount);
    }
    int dfs(vector<int>& coins, int amount) {
        if (amount==0) return 0;
        if (amount<0) return -1;
        if (memo[amount]!=-67) return memo[amount];

        int ret=INT_MAX;
        for (int coin : coins)
        {
            int sub=dfs(coins, amount-coin);
            if (sub==-1) continue;
            ret=min(ret, 1+sub);
        }

        memo[amount]=ret==INT_MAX ? -1 : ret;
        return memo[amount];
    }

    int coinChange2(vector<int>& coins, int amount) {
        vector<int> dp(amount+1, amount+1);
        dp[0]=0;
        for (int i=1; i<=amount; i++)
        {
            for (int coin : coins)
            {
                if (i<coin) continue;
                dp[i]=min(dp[i], 1+dp[i-coin]);
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }

    int coinChange3(vector<int>& coins, int amount) {
        int ret=0;
        queue<int> q;
        vector<bool> visited(amount+1);
        q.push(amount);
        visited[amount]=true;
        while(!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                int cur=q.front();
                q.pop();

                if (cur==0) return ret;

                for (int coin : coins)
                {
                    int next=cur-coin;
                    if (next<0) continue;
                    if (visited[next]) continue;

                    q.push(next);
                    visited[next]=true;
                }
            }
            ret+=1;
        }
        return -1;
    }
};
