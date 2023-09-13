class Solution {
public:
    vector<int> findMinHeightTreesForce(int n, vector<vector<int>>& edges) {
        // build gragh
        vector<vector<int>> g;
        for (int i=0; i<n; i++)
            g.push_back(vector<int>());

        for (int i=0; i<edges.size(); i++)
        {
            int p1=edges[i][0], p2=edges[i][1];
            g[p1].push_back(p2);
            g[p2].push_back(p1);
        }

        vector<int> ret;
        int min=INT_MAX;
        // cal height in all nodes
        for(int v=0; v<n; v++)
        {
            vector<bool> visited(n, false);
            queue<int> q;
            q.push(v);
            visited[v]=true;
            int height=0;
            while(!q.empty())
            {
                int size=q.size();
                while(size--)
                {
                    int cur=q.front();
                    q.pop();

                    for (int next : g[cur]) {
                        if (visited[next]) continue;
                        q.push(next);
                        visited[next]=true;
                    }
                }
                height+=1;
            }

            // update ret/min
            if (min>height)
            {
                min=height;
                ret.clear();
                ret.push_back(v);
            } else if (min==height) {
                ret.push_back(v);
            }
        }

        return ret;
    }

    vector<int> findMinHeightTreesTopo(int n, vector<vector<int>>& edges) {
        // build gragh
        vector<vector<int>>g(n);
        vector<int> degree(n);
        for (int i=0; i<edges.size(); i++)
        {
            int a=edges[i][0], b=edges[i][1];
            g[a].push_back(b);
            g[b].push_back(a);
            degree[a]++;
            degree[b]++;
        }

       queue<int> q;
        for (int i=0; i<degree.size(); i++)
            if (degree[i]<2)
                q.push(i);

        int remainLeaves=n;
        while(!q.empty()&&remainLeaves>2)
        {
            int size=q.size();
            while(size--)
            {
                int cur=q.front();
                q.pop();
                remainLeaves--;

                for (int next : g[cur])
                {
                    degree[next]--;
                    if (degree[next]==1)
                        q.push(next);
                }
            }
        }

        vector<int> ret;
        for(; !q.empty(); q.pop())
            ret.push_back(q.front());

        return ret;
    }
};