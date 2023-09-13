package practices.backtrack.s46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        backtrack(nums, new LinkedList<>(), new boolean[nums.length], res);
        return res;
    }
    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used, List<List<Integer>> res) {
        if (track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;

            track.add(nums[i]);
            used[i]=true;
            backtrack(nums, track, used, res);
            track.removeLast();
            used[i]=false;
        }
    }
}
