package practices.backtrack.s39;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret=new LinkedList<>();
        backtrack(candidates, target, new LinkedList<>(), 0);
        return ret;
    }
    private void backtrack(int[] candidates, int target, LinkedList<Integer> track, int start) {
        if (target==0) {
            ret.add(new LinkedList<>(track));
            return;
        }

        for (int i=start; i<candidates.length; i++) {
            if (target<candidates[i]) continue;

            track.add(candidates[i]);
            backtrack(candidates, target-candidates[i], track, i);
            track.removeLast();
        }
    }
}
