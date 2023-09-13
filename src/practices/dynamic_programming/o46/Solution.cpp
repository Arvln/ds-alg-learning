class Solution {
public:
    int translateNum(int num) {
        string s=to_string(num);
        int n=s.size();
        vector<int> dp(n+1, 0);
        dp[0]=1;
        dp[1]=1;

        for (int i=2; i<=n; i++)
        {
            char c=s[i-2], d=s[i-1];
            dp[i]+=dp[i-1];
            if (c=='1'||c=='2'&&d<='5')
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
};