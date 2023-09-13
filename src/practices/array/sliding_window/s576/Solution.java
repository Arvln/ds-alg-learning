package practices.array.sliding_window.s576;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char w = s1.charAt(i);
            need.put(w, need.getOrDefault(w, 0)+1);
        }

        int left=0, right=0, valid=0;
        while (right<s2.length()) {
            char c = s2.charAt(right);

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).equals(window.get(c))) valid++;
            }
            right++;

            if (right-left>s1.length()) {
                char d = s2.charAt(left);

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) valid--;
                    window.put(d, window.get(d)-1);
                }

                left++;
            }
            if (valid==need.size()) return true;
        }

        return false;
    }
    /**
     *  判斷是否包含特定异位词的子串
     *
     * tips
     * 同438
     *
     * */
}
