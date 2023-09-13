package practices.backtrack.s491;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;
    LinkedList<Integer> track;
    int N;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ret=new LinkedList<>();
        track=new LinkedList<>();
        N=nums.length;
        dfs(nums, 0);
        return ret;
    }
    void dfs(int[] nums, int start)
    {
        if (track.size()>1)
            ret.add(new LinkedList<>(track));

        HashSet<Integer> used=new HashSet<>();
        for (int i=start; i<N; i++)
        {
            if (!track.isEmpty()&&track.getLast()>nums[i])
                continue;
            if (used.contains(nums[i])) continue;

            used.add(nums[i]);
            track.add(nums[i]);
            dfs(nums, i+1);
            track.removeLast();
        }
    }
}
