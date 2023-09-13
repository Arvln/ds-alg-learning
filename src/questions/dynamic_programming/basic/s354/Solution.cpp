class Solution {
public:
    int maxEnvelopes1(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>&a, const vector<int>&b) {
            if (a[0]==b[0]) return a[1]>b[1];
            return a[0]<b[0];
        });

        int N=envelopes.size();
        vector<int> dp(N, 1);
        int ret=0;
        for (int i=0; i<N; i++)
        {
            for (int j=0; j<i; j++)
            {
                if (envelopes[j][1]<envelopes[i][1])
                    dp[i]=max(dp[i], 1+dp[j]);
            }
            ret=max(ret, dp[i]);
        }

        return ret;
    }
    int maxEnvelopes2(vector<vector<int>>& envelopes) {
        sort(envelopes.begin(), envelopes.end(), [](const vector<int>&a, const vector<int>&b) {
            if (a[0]==b[0]) return a[1]>b[1];
            return a[0]<b[0];
        });

        vector<int> q;
        for (vector<int> e : envelopes)
        {
            if (q.empty() || q.back()<e[1])
                q.push_back(e[1]);
            else
            {
                auto iter=lower_bound(q.begin(), q.end(), e[1]);
                *iter=e[1];

                /**
                    int left=0, right=q.size();
                    while(left<right)
                    {
                        int mid=left+((right-left)>>1);

                        if (q[mid]==e[1])
                            right=mid;
                        else if (q[mid]<e[1])
                            left=mid+1;
                        else
                            right=mid;
                    }
                    q[left]=e[1];
                */
            }
        }

        return q.size();
    }
};
