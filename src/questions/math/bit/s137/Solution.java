package questions.math.bit.s137;

public class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i=0; i<32; i++) {
            int total=0;
            for (int num : nums) total+=(num>>i)&1;
            if (total%3==1) res|=1<<i;
        }
        return res;
    }
}
