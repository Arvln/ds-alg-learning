package practices.backtrack.s216;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;
    LinkedList<Integer> track;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret=new LinkedList<>();
        track=new LinkedList<>();
        dfs(k, n, 1);
        return ret;
    }
    void dfs(int k, int n, int start)
    {
        if (k==0&&n==0)
        {
            ret.add(new LinkedList<>(track));
            return;
        }

        for (int i=start; i<10; i++)
        {
            if (n<i) continue;

            track.add(i);
            dfs(k-1, n-i, i+1);
            track.removeLast();
        }
    }
}
