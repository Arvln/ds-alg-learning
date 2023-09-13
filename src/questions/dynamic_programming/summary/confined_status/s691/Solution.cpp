class Solution {
public:
    int minStickers(vector<string>& stickers, string target) {
        int n=target.size();
        int N=(1<<n);
        vector<int>dp(N, INT_MAX);
        dp[0]=0;

        for (int i=0; i<N; i++)
        {
            if (dp[i]==INT_MAX) continue;

            for (string sticker : stickers)
            {
                int j=findNextStatus(i,sticker,target);
                dp[j]=min(dp[j], dp[i]+1);
            }
        }
        return dp[N-1]==INT_MAX?-1:dp[N-1];
    }
    int findNextStatus(int status, string sticker, string target)
    {

        for (char c : sticker)
            for (int k=0; k<target.size(); k++)
            {
                if ((status>>k&1)==0&&c==target[k])
                {
                    status+=(1<<k);
                    break;
                }
            }
        return status;
    }
};

// "thehat"
// 111111 -> 63

// "the"
// 111000 -> 56

// "ha" -> 6
// 000110

// "t" -> 1
// 000001