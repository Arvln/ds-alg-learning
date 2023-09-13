class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int left=0, right=0, ret=INT_MIN, cur=0;
        while(right<nums.size())
        {
            cur+=nums[right];
            right++;

            ret=max(ret, cur);

            while (cur<0)
            {
                cur-=nums[left];
                left++;
            }
        }
        return ret;
    }
};