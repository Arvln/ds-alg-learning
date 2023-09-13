package practices.backtrack.s17;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res=new LinkedList<>();
        if (digits.isEmpty()) return res;
        backtrack(digits, 0, mapping, new StringBuilder(), res);
        return res;
    }
    private void backtrack(String digits, int i, String[] mapping, StringBuilder sb, List<String> res) {
        if (i==digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str=mapping[digits.charAt(i)-'0'];

        for (char c : str.toCharArray()) {
            sb.append(c);
            backtrack(digits, i+1, mapping, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
