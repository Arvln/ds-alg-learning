package practices.array.sliding_window.s424;

import java.util.HashMap;

public class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left=0, right=0, maxN=Integer.MIN_VALUE;
        while (right<s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            maxN=Integer.max(maxN, window.get(c));
            right++;

            if (right-left-maxN>k) {
                char d = s.charAt(left);
                window.put(d, window.get(d)-1);
                left++;
            }
        }

        return right-left;
    }
    /**
     *  选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     *  在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     *
     * tips
     * 同1004
     *
     * */
}
