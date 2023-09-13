package practices.backtrack.s140;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res=new LinkedList<>();
        backtrack(s, wordDict, 0, new LinkedList<>(), res);
        return res;
    }
    private void backtrack(String s, List<String> wordDict, int start, LinkedList<String> track, List<String> res) {
        if (start==s.length()) {
            res.add(String.join(" ", track));
            return;
        }


        for (int i=start; i<s.length(); i++) {
            String cur=s.substring(start, i+1);
            if (!wordDict.contains(cur)) continue;

            track.add(cur);
            backtrack(s, wordDict, i+1, track, res);
            track.removeLast();
        }
    }
}
