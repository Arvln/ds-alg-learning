class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });

        int end=intervals[0][1], ret=-1;
        for (vector<int> interval : intervals)
        {
            if (interval[0]>=end)
                end=interval[1];
            else
                ret=ret+1;
        }
        return ret;
    }
};