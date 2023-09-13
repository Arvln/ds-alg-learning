class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int mask=0;
        for (int num : nums)
            mask^=num;

        int k=1;
        while ((mask&k)==0)
            k<<=1;

        vector<int> ret(2);
        for (int num : nums)
        {
            if ((num&k)==0)
                ret[0]^=num;
            else
                ret[1]^=num;
        }
        return ret;
    }
};
