class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int ret=0;
        for (int i=0; i<32; i++)
        {
            int k=1<<i, sum1=0, sum2=0;
            for (int i=0; i<nums.size(); i++)
            {
                if ((i&k)==k)
                    sum1+=1;
                if ((nums[i]&k)==k)
                    sum2+=1;
            }

            if (sum2>sum1)
                ret|=k;
        }
        return ret;
    }
};
