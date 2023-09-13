class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n=envelopes.size();
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[0]==b[0]) return a[1]>b[1];
            return a[0]<b[0];
        });
        vector<int> ret;
        ret.push_back(envelopes[0][1]);

        for (int i=1; i<n; i++)
        {
            if (envelopes[i][1]>ret.back())
                ret.push_back(envelopes[i][1]);
            else
            {
                auto iter=lower_bound(ret.begin(), ret.end(), envelopes[i][1]);
                *iter=envelopes[i][1];
            }
        }
        return ret.size();
    }
};