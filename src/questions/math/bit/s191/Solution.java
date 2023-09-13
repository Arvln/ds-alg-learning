package questions.math.bit.s191;

public class Solution {
    public int hammingWeight(int n) {
        int res=0;
        for (; n!=0; n&=n-1, res++);
        return res;
    }
}
