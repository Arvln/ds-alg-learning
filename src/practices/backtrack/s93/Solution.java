package practices.backtrack.s93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> ret;
    LinkedList<String> track;
    public List<String> restoreIpAddresses(String s) {
        ret=new LinkedList<>();
        track=new LinkedList<>();
        dfs(s, 0);
        return ret;
    }
    private void dfs(String s, int start)
    {
        if (start==s.length()&&track.size()==4)
        {
            ret.add(String.join(".", track));
            return;
        }

        for (int i=start; i<s.length(); i++)
        {
            String cur=s.substring(start, i+1);
            if (!isValid(cur)) continue;
            if (track.size()==4) break;

            track.add(cur);
            dfs(s, i+1);
            track.removeLast();
        }
    }
    private boolean isValid(String s) {
        int len=s.length();

        if (len==0||len>3) return false;
        if (s.charAt(0)=='0') return len==1;
        return Integer.parseInt(s) <= 255;
    }
}
