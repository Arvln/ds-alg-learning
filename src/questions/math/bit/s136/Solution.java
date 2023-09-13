package questions.math.bit.s136;

public class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int num: nums) res^=num;
        return res;
    }
}
