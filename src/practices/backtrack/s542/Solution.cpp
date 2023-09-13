class Solution {
public:
    vector<vector<int>> updateMatrixForce(vector<vector<int>>& mat) {
        int m=mat.size(), n=mat[0].size();
        vector<vector<int>>ret(m, vector(n, 0));
        vector<vector<int>>dirs{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (mat[i][j]==0) continue;

                int step=0;
                queue<vector<int>> q;
                vector<vector<bool>> visited(m, vector(n, false));
                q.push({i,j});
                visited[i][j]=true;
                bool found=false;
                while(!q.empty()&&!found)
                {
                    int size=q.size();
                    while(!found&&size--)
                    {
                        int x=q.front()[0], y=q.front()[1];
                        q.pop();

                        for (vector<int> dir : dirs)
                        {
                            int nx=x+dir[0], ny=y+dir[1];

                            if (nx<0||ny<0||nx>=m||ny>=n) continue;
                            if (visited[nx][ny]) continue;
                            if (mat[nx][ny]==0) found=true;

                            q.push({nx, ny});
                            visited[nx][ny]=true;
                        }
                    }
                    step++;
                }
                ret[i][j]=step;
            }
        }
        return ret;
    }
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m=mat.size(), n=mat[0].size();
        vector<vector<int>>ret(m, vector(n, -1));
        vector<vector<int>>dirs{{1,0},{0,1},{-1,0},{0,-1}};
        queue<vector<int>> q;
        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (mat[i][j]==0) {
                    q.push({i,j});
                    ret[i][j]=0;
                }

        int step=0;
        while(!q.empty())
        {
            int size=q.size();
            while(size--)
            {
                int x=q.front()[0], y=q.front()[1];
                q.pop();

                if (ret[x][y]==-1)
                    ret[x][y]=step;

                for (vector<int> dir : dirs)
                {
                    int nx=x+dir[0], ny=y+dir[1];
                    if (nx<0||ny<0||nx>=m||ny>=n) continue;
                    if (ret[nx][ny]==-1)
                        q.push({nx,ny});
                }
            }
            step++;
        }

        return ret;
    }
};