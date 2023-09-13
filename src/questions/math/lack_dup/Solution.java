package questions.math.lack_dup;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] used=new boolean[nums.length];

        int dup=0;
        for (int num : nums) {
            if (used[num-1]) dup=num;
            else used[num-1]=true;
        }

        int missing=0;
        for (int i=0; i<used.length; i++) {
            if (used[i]) continue;
            missing=i+1;
        }

        return new int[]{dup, missing};
    }
}
