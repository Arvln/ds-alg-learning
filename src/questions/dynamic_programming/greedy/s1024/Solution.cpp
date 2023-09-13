class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        sort(clips.begin(), clips.end(), [](const vector<int>&a, vector<int>&b){
            if (a[0]==b[0]) return a[1]>b[1];
            return a[0]<b[0];
        });
        if (clips[0][0]>0) return -1;
        int count=1;
        if (clips[0][1]>=time) return count;

        int right=clips[0][1], i=0;
        while(i<clips.size())
        {
            int farReach=right;
            while(i<clips.size()&&clips[i][0]<=right)
            {
                farReach=max(farReach, clips[i][1]);
                i++;
            }
            count++;
            if (farReach==right) return -1;
            right=farReach;
            if (right>=time) return count;
        }
        return -1;
    }
};