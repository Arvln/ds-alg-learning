class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int m=maze.size(), n=maze[0].size();
        int ret=0;
        vector<vector<int>> dirs{{1,0},{0,1},{-1,0},{0,-1}};
        queue<vector<int>> q;
        q.push(entrance);
        maze[entrance[0]][entrance[1]]='#';
        while(!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                int i=q.front()[0], j=q.front()[1];
                q.pop();

                for (vector<int> dir : dirs)
                {
                    int x=i+dir[0], y=j+dir[1];
                    if (x<0||y<0||x>=m||y>=n) {
                        if (ret==0) continue;
                        else return ret;
                    }
                    if (maze[x][y]!='.') continue;

                    q.push({x, y});
                    maze[x][y]='#';
                }
            }
            ret+=1;
        }
        return -1;
    }
};
