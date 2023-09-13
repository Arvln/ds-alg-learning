class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>>ret;
        sort(intervals.begin(), intervals.end(), [](const vector<int>&a, const vector<int>&b){
            return a[0]<b[0];
        });
        int left=intervals[0][0], right=intervals[0][1];
        for (vector<int> interval : intervals)
        {
            if (interval[0]<=right)
                right=max(right, interval[1]);
            else
            {
                ret.push_back({left, right});
                left=interval[0], right=interval[1];
            }
        }
        ret.push_back({left, right});
        return ret;
    }
};