package questions.math.bit.s260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for (int num : nums) xor^=num;

        int bit=1;
        while((xor&bit)==0) bit<<=1;

        int[] res=new int[2];
        for (int num : nums) {
            if ((num&bit)==0) res[0]^=num;
            else res[1]^=num;
        }

        return res;
    }
}
