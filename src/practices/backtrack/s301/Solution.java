package practices.backtrack.s301;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> all=new LinkedList<>();
        backtrack(s, 0, new StringBuilder(), all);
        int maxLen=0;
        for (String str : all) maxLen=Math.max(maxLen, str.length());
        List<String> res=new LinkedList<>();
        for (String str : all) {
            if (str.length()==maxLen) res.add(str);
        }
        return res;

    }
    private void backtrack(String s, int i, StringBuilder sb, List<String> res) {
        if (i==s.length()) {
            if (isValid(sb.toString()))
                res.add(sb.toString());
            return;
        }

        char c=s.charAt(i);
        if (c!='('&&c!=')') {
            sb.append(c);
            backtrack(s, i+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append(c);
            backtrack(s, i+1, sb, res);
            sb.deleteCharAt(sb.length()-1);

            String cur=sb.toString();
            if (cur.isEmpty() || c!=cur.charAt(cur.length()-1)) backtrack(s, i+1, sb, res);
        }
    }
    private boolean isValid(String s) {
        int left=0;

        for (char c : s.toCharArray()) {
            if (c=='(') left++;
            if (c==')') left--;
            if (left<0) return false;
        }
        return left==0;
    }
}
