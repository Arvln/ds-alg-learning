package practices.backtrack.s131;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new LinkedList<>();
        backtrack(s, 0, new LinkedList<>(), res);
        return res;
    }
    private void backtrack(String s, int start, LinkedList<String> track, List<List<String>> res) {
        if (start==s.length()) {
            res.add(new LinkedList<>(track));
            return;
        }


        for (int i=start; i<s.length(); i++) {
            if (!isPalindrome(s, start, i)) continue;

            track.add(s.substring(start, i+1));
            backtrack(s, i+1, track, res);
            track.removeLast();
        }
    }
    private boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
