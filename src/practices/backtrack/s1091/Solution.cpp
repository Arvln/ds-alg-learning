class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n=grid.size();
        if (grid[0][0]==1) return -1;

        int ret=0;
        vector<vector<int>> dirs{
            {1,0},
            {0,1},
            {-1,0},
            {0,-1},
            {-1,-1},
            {-1,1},
            {1,-1},
            {1,1},
        };
        queue<vector<int>> q;
        q.push({0, 0});
        while (!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                int i=q.front()[0], j=q.front()[1];
                q.pop();

                if (i==n-1&&i==j) return ret+1;

                for (vector<int> dir : dirs)
                {
                    int x=i+dir[0], y=j+dir[1];

                    if (x<0||y<0||x>=n||y>=n) continue;
                    if (grid[x][y]!=0) continue;

                    q.push({x, y});
                    grid[x][y]=2;
                }
            }
            ret+=1;
        }
        return -1;
    }
};
