package questions.backtrack.s22;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new LinkedList<>();
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }
    private void backtrack(int left, int right, StringBuilder sb, List<String> res) {
        if (left<0||right<0) return;
        if (left>right) return;
        if (left==0&&right==0) {
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        backtrack(left-1, right, sb, res);
        sb.deleteCharAt(sb.length()-1);

        sb.append(')');
        backtrack(left, right-1, sb, res);
        sb.deleteCharAt(sb.length()-1);
    }
}
