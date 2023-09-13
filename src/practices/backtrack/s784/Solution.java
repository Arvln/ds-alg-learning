package practices.backtrack.s784;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<String> ret;
    public List<String> letterCasePermutation(String s) {
        ret=new LinkedList<>();
        dfs(s, new StringBuilder(), 0);
        return ret;
    }
    private void dfs(String s, StringBuilder sb, int i)
    {
        if (i==s.length())
        {
            ret.add(sb.toString());
            return;
        }
        char c=s.charAt(i);

        if ('0'<=c&&c<='9')
        {
            sb.append(c);
            dfs(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
        else
        {
            char up=Character.toUpperCase(c), low=Character.toLowerCase(c);

            sb.append(up);
            dfs(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(low);
            dfs(s, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
