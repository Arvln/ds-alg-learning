class Solution {
public:
    int fib1(int n) {
        vector<int> memo(n+1);
        return dfs(n, memo);
    }
    int dfs(int n, vector<int>&memo) {
        if (n==0||n==1)
            return n;
        if (memo[n]!=0)
            return memo[n];

        memo[n]=dfs(n-1, memo)+dfs(n-2, memo);
        return memo[n];
    }
    int fib2(int n) {
        int cur=0, next=1;
        for (int i=1; i<=n; i++)
        {
            int tmp=cur+next;
            cur=next;
            next=tmp;
        }
        return cur;
    }
};
