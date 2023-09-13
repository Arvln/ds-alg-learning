class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<bool> visited(nums.size()+1);
        vector<int> ret;
        for (int num : nums)
        {
            if (visited[num])
            {
                ret.push_back(num);
                continue;
            }
            visited[num]=true;
        }
        for (int i=1; i<visited.size(); i++)
            if (!visited[i])
                ret.push_back(i);

        return ret;
    }
};
