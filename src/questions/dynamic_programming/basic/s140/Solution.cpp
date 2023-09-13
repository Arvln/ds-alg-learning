class Solution {
    vector<string> wordDict;
    vector<string> ret;
    vector<string> track;
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        this->wordDict=wordDict;
        dfs(s, 0);
        return ret;
    }
    void dfs(string s, int i)
    {
        if (i==s.size())
        {
            string result;
            for (string word : track)
                result+=word+" ";
            result.pop_back();
            ret.push_back(result);
        }

        for (string word : wordDict)
        {
            int len=word.size();
            if (s.substr(i, len)==word)
            {
                track.push_back(word);
                dfs(s, i+len);
                track.pop_back();
            }
        }
    }
};