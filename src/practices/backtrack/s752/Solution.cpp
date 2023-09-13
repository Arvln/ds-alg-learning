class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        int ret=0;
        unordered_set<string> visited;
        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        while(!q.empty())
        {
            int size=q.size();
            while (size--)
            {
                string cur=q.front();
                q.pop();

                if (find(deadends.begin(), deadends.end(), cur)!=deadends.end()) continue;
                if (cur==target) return ret;

                for (string next : scroll(cur))
                {
                    if (visited.find(next)!=visited.end()) continue;

                    q.push(next);
                    visited.insert(next);
                }
            }
            ret+=1;
        }
        return -1;
    }
    vector<string> scroll(string s)
    {
        vector<string> rets;
        for (int i=0; i<4; i++)
            for (int j=-1; j<=1; j+=2)
            {
                int num=s[i]-'0';
                num=(num+j+10)%10;
                string tmp=s;
                tmp[i]='0'+num;
                rets.push_back(tmp);
            }

        return rets;
    }
};
