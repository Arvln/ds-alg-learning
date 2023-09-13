class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        int n=req_skills.size();
        int N=(1<<n);
        vector<int>dp(N, INT_MAX);
        vector<pair<int, int>>prev(N);
        dp[0]=0;

        for (int i=0; i<N; i++)
        {
            if (dp[i]==INT_MAX) continue;
            for (int k=0; k<people.size(); k++)
            {
                int j=findNextStatus(i, people[k], req_skills);
                dp[j]=min(dp[j], dp[i]+1);
                if (dp[j]==dp[i]+1)
                    prev[j]={i,k};
            }
        }

        vector<int>ret;
        for (int i=N-1; i!=0; i=prev[i].first)
            ret.push_back(prev[i].second);

        return ret;
    }
    int findNextStatus(int status, vector<string>& skills, vector<string>& req_skills)
    {
        for (string skill : skills)
            for (int k=0; k<req_skills.size(); k++)
            {
                if ((status>>k&1)==0&&skill==req_skills[k])
                {
                    status+=(1<<k);
                    break;
                }
            }
        return status;
    }
};