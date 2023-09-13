class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        int m=2, n=3;
        string start, target="123450";
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                start+=to_string(board[i][j]);

        int ret=0;
        queue<string> q;
        unordered_set<string> visited;
        q.push(start);
        visited.insert(start);
        vector<vector<int>> dirs{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };
        while(!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                string cur=q.front();
                q.pop();

                if (cur==target) return ret;
                int index=0;
                for (; cur[index]!='0'; index++);

                for (int pos : dirs[index])
                {
                    string next=swap(cur, index, pos);
                    if (visited.find(next)!=visited.end()) continue;
                    q.push(next);
                    visited.insert(next);
                }
            }
            ret++;
        }
        return -1;
    }
    string swap(string s, int index, int pos)
    {
        char tmp=s[index];
        s[index]=s[pos];
        s[pos]=tmp;
        return s;
    }
};
