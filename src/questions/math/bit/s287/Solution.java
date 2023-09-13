package questions.math.bit.s287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int res=0;
        for (int i=0; i<32; i++) {
            int bit=1<<i, s1=0, s2=0;

            for (int j=0; j<nums.length; j++) {
                if ((j&bit)==bit) s1++;
                if ((nums[j]&bit)==bit) s2++;
            }
            if (s2>s1) res|=bit;
        }
        return res;
    }

    public static void main(String[] args) {
        char c='a';
        System.out.println((char)(c^'a'^'b'));
    }
}
