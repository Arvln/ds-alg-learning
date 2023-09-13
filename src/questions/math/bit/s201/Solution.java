package questions.math.bit.s201;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left<right) {
            right&=right-1;
        }
        return right;
    }
}
