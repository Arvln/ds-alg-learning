class Solution {
    vector<string> wordDict;
    vector<int> memo;
    vector<vector<string>> memo;
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        this->wordDict=wordDict;
        memo=vector<int>(s.size(), -1);
        return dfs(s, 0);
    }
    bool dfs(string& s, int i)
    {
        if (i==s.size()) return true;
        if (memo[i]!=-1) return memo[i]==1;

        bool ret=false;
        for (string word : wordDict)
        {
            int len=word.size();
            if (s.substr(i, len)==word)
                ret=ret||dfs(s, i+len);
        }
        memo[i]=ret;
        return ret;
    }
};