class Solution {
public:
    int jump(vector<int>& nums) {
        int ret=0;
        for (int i=0, far_reach=0, pos=0; i<nums.size()-1; i++)
        {
            far_reach=max(far_reach, i+nums[i]);
            if (i==pos)
            {
                ret+=1;
                pos=far_reach;
            }
        }
        return ret;
    }
};