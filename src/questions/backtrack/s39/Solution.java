package questions.backtrack.s39;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, LinkedList<Integer> track) {
        if (target==0) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (target<candidates[i]) continue;

            track.add(candidates[i]);
            target-=candidates[i];
            backtrack(candidates, target, i, track);
            track.removeLast();
            target+=candidates[i];
        }
    }
}
