package questions.backtrack.s77;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        if (k==0) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i=start; i<=n; i++) {
            track.add(i);
            k--;
            backtrack(n, k, i+1, track);
            track.removeLast();
            k++;
        }
    }
}
