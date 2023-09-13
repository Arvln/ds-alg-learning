package questions.backtrack.s78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, LinkedList<Integer> track) {

        res.add(new LinkedList<>(track));

        for (int i=start; i<nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1, track);
            track.removeLast();
        }
    }
}
