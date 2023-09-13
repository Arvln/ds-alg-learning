package practices.array.two_pointer.o57;


import java.util.ArrayList;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();

        int left=1, right=1, sum=0, count=0;
        while (right<target) {
            sum+=right;
            right++;

            while (sum>target) {
                sum-=left;
                left++;
            }

            if (sum==target) {
                int[] ans = new int[right - left];

                for (int i = 0; i < ans.length; i++) {
                    ans[i]=left+i;
                }

                result.add(ans);
                count++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
