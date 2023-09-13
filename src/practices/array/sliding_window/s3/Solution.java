package practices.array.sliding_window.s3;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left=0, right=0, max=0;
        while (right<s.length()) {
            char c = s.charAt(right);

            window.put(c, window.getOrDefault(c, 0)+1);
            right++;

            while (window.get(c)>1) {
                char d = s.charAt(left);

                window.put(d, window.get(d)-1);
                left++;
            }
            max = Integer.max(max, right-left);
        }

        return max;
    }
    /**
     * 不含有重复字符的 最长子串
     *
     * tips
     * 1, 統計[left..right)內各個字符總數
     * 2, 總數大於1即為重複可右移左界
     * 3, 每次右移右界更新結果
     *
     * */
}
