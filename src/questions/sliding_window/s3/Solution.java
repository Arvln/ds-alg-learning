package questions.sliding_window.s3;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0; int right = 0;
        int max = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;

            while (left < right && map.get(c) > 1) {
                char d = s.charAt(left);

                map.put(d, map.get(d) - 1);
                left++;
            }
            max = Integer.max(max, right - left);
        }

        return max;
    }
}
