class Solution {
public:
    int numDecodings(string s) {
        int n=s.size();
        vector<int> dp(n+1, 0);
        dp[0]=1;
        if (s[0]>'0') dp[1]=1;

        for (int i=2; i<=n; i++)
        {
            char c=s[i-2], d=s[i-1];
            if ('0'<d&&d<='9')
                dp[i]+=dp[i-1];
            if (c=='1'||c=='2'&&d<='6')
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
};