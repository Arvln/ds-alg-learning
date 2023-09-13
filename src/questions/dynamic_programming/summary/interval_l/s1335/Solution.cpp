class Solution {
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        int n=jobDifficulty.size();
        if (n<d) return -1;
        jobDifficulty.insert(jobDifficulty.begin(), 0);
        vector<vector<int>>dp(n+1, vector<int>(d+1, INT_MAX/2));
        dp[0][0]=0;

        for (int i=1; i<=n; i++)
            for (int k=1; k<=min(i, d); k++)
                for (int j=i; j>=k; j--)
                    dp[i][k]=min(dp[i][k], dp[j-1][k-1]+maxDiff(jobDifficulty, j, i));

        return dp[n][d];
    }
    int maxDiff(vector<int>& jobDifficulty, int a, int b)
    {
        int max=jobDifficulty[a];
        a++;
        while(a<=b)
        {
            if (jobDifficulty[a]>max)
                max=jobDifficulty[a];
            a++;
        }
        return max;
    }
};

// X X X X X X X [j X X i] => min{ dp[j-1][k-1]+maxDiff(j, i) } for j=1 .. i

// dp[i][k]: k天的工作难度是当天完成工作的最大难度求job[0:i]的最小难度和