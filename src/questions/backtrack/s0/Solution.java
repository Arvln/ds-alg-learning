package questions.backtrack.s0;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> multipleSelect(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
