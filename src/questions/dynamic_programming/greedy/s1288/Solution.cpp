class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>&a, const vector<int>&b){
            if (a[0]==b[0]) return a[1]>b[1];
            return a[0]<b[0];
        });
        int count=0, end=-1;
        for (vector<int> interval : intervals)
        {
            if (interval[1]>end)
                end=interval[1];
            else
                count++;
        }
        return intervals.size()-count;
    }
};