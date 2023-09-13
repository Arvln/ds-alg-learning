package questions.backtrack.s46;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;

            used[i]=true;
            track.add(nums[i]);
            backtrack(nums, track, used);
            used[i]=false;
            track.removeLast();
        }
    }
}
