class Solution {
    vector<string> ret;
    vector<string> track;
    vector<string> wordDict;
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        this->wordDict=wordDict;
        backtrack(s, 0);
        return ret;
    }
    void backtrack(string s, int i)
    {
        int n=s.size();
        if (i==n)
        {
            string sen;
            for (string word : track) {
                sen.append(word);
                sen.append(" ");
            }
            sen.pop_back();
            ret.push_back(sen);
            return;
        }

        for (string word : wordDict)
        {
            int len=word.size();
            if (i+len>n) continue;
            string cur=s.substr(i, len);
            if (word==cur)
            {
                track.push_back(cur);
                backtrack(s, i+len);
                track.pop_back();
            }
        }
    }
};