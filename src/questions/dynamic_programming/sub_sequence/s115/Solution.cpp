class Solution {
    vector<int> memo;
public:
    int numDistinct(string s, string t) {
        memo=vector<int>(1<<20, -1);
        return dp(s, 0, t, 0);
    }
    int dp(string s, int i, string t, int j)
    {
        if (j==t.size()) return 1;
        if (s.size()-i<t.size()-j) return 0;
        int state=(i<<10)+j;
        if (memo[state]!=-1) return memo[state];

        int ret=0;
        if (s[i]==t[j])
            ret+=dp(s, i+1, t, j+1)+dp(s, i+1, t, j);
        else
            ret+=dp(s, i+1, t, j);

        memo[state]=ret;
        return ret;
    }
};