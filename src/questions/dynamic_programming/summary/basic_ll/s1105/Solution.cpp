class Solution {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        int n=books.size();
        vector<int>dp(n+1, INT_MAX);
        books.insert(books.begin(), {0,0});
        dp[0]=0;

        for (int i=1; i<=n; i++)
        {
            int height=0, width=0;
            for (int j=i; j>=1; j--)
            {
                height=max(height, books[j][1]);
                width+=books[j][0];
                if (width>shelfWidth) break;
                dp[i]=min(dp[i], dp[j-1]+height);
            }
        }
        return dp[n];
    }
};

// dp[i]: 书架整体可能的最小高度 ending with ith book
// current level => i~jth book has height
// dp[i] = min(dp[i], dp[j-1]+height)