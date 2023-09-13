class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n=s.size();
        vector<bool> dp(n+1, false);
        dp[0]=true;

        for (int i=1; i<=n; i++)
            for (string word : wordDict)
            {
                int len=word.size();
                if (i>=len && s.substr(i-len, len)==word)
                    dp[i]=dp[i]||dp[i-len];
            }

        return dp[n];
    }
};