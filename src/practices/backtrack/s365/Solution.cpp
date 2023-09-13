class Solution {
public:
    bool canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        vector<vector<int>> dirs{{1,0},{0,1},{-1,0},{0,-1}};
        queue<int> q;
        unordered_set<int> visited;
        q.push(0);
        visited.insert(0);
        while(!q.empty())
        {
            int cur=q.front();
            q.pop();

            if (cur==targetCapacity)
                return true;

            for (vector<int> dir : dirs)
            {
                int next=cur+jug1Capacity*dir[0]+jug2Capacity*dir[1];
                if (next<0||next>jug1Capacity+jug2Capacity) continue;
                if (visited.find(next)!=visited.end()) continue;

                q.push(next);
                visited.insert(next);
            }
        }
        return false;
    }
};
