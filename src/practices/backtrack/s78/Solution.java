package practices.backtrack.s78;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> subsets(int[] nums) {
        ret=new LinkedList<>();
        dfs(nums, 0, new LinkedList<>());
        return ret;
    }
    private void dfs(int[] nums, int start, LinkedList<Integer> track)
    {
        ret.add(new LinkedList<>(track));

        for (int i=start; i<nums.length; i++)
        {
            track.add(nums[i]);
            dfs(nums, i+1, track);
            track.removeLast();
        }
    }
}
