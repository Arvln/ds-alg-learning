package questions.backtrack.s47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, LinkedList<Integer> track) {
        if (track.size()==nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;

            track.add(nums[i]);
            used[i]=true;
            backtrack(nums, used, track);
            track.removeLast();
            used[i]=false;
        }
    }
}
