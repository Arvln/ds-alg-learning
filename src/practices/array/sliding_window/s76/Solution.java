package practices.array.sliding_window.s76;

import java.util.HashMap;

public class Solution {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char w = t.charAt(i);
            needs.put(w, needs.getOrDefault(w, 0)+1);
        }

        int left=0, right=0, valid=0, start=0, end=Integer.MAX_VALUE;
        while (right<s.length()) {
            char c = s.charAt(right);

            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (needs.get(c).equals(window.get(c))) valid++;
            }
            right++;

            while (valid==needs.size()) {
                if (right-left<end-start) {
                    start=left;
                    end=start+right-left;
                }

                char d = s.charAt(left);

                if (needs.containsKey(d)) {
                    if (needs.get(d).equals(window.get(d))) valid--;
                    window.put(d, window.get(d)-1);
                }
                left++;
            }
        }

        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
    /**
     *  涵盖指定字串所有字符的最小子串
     *
     * tips
     * 同438
     *
     * */
}
