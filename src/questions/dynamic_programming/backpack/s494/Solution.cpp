class Solution {
    unordered_map<string, int> memo;
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        memo=unordered_map<string, int>();
        return backtrack(nums, target, 0);
    }
    int backtrack(vector<int>& nums, long target, int i)
    {
        if (i==nums.size())
        {
            if (target==0) return 1;
            return 0;
        }
        string state=to_string(i)+","+to_string(target);
        if (memo.find(state)!=memo.end()) return memo[state];

        memo[state]=backtrack(nums, target-nums[i], i+1)+backtrack(nums, target+nums[i], i+1);

        return memo[state];
    }
};