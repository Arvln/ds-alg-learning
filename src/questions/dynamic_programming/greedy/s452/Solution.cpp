class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), [](const vector<int>&a, const vector<int>&b) {
            return a[1]<b[1];
        });
        int ret=1, end=points[0][1];
        for (vector<int> point : points)
        {
            if (point[0]>end)
            {
                ret=ret+1;
                end=point[1];
            }
        }
        return ret;
    }
};