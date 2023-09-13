package questions.sliding_window.s567;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 初始化題目要求字符與數量的哈希表 { [key: char]: [value: int] }
        // 初始化區間內題目要求字符與數量的狀態
        HashMap<Character, Integer> required = new HashMap<>();

        for (char c : s1.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> intervalState = new HashMap<>();

        // 初始化左右指針、有效字符串數量
        int left = 0; int right = 0;
        int valid = 0;
        // 遍歷字串
        while (right < s2.length()) {
            // 獲取即將加入區間字符
            char c = s2.charAt(right);

            // 檢查是否是題目邀前字符，是的話更新當前區間狀態及有效字符串數量
            if (required.containsKey(c)) {
                intervalState.put(c, intervalState.getOrDefault(c, 0) + 1);
                // 當前字符數等於題目要求數量，當前字符屬於有效字符，有效字符數+1
                if (intervalState.get(c).equals(required.get(c))) valid++;
            }
            right++;

            // left在right左側且區間內含有所有題目要求字符時，收緊區間
            while (left < right && valid == required.size()) {
                // 檢查區間是否跟題目要求字符等長
                if (right - left == s1.length()) return true;

                // 獲取即將移除區間字符
                char d = s2.charAt(left);

                // 檢查是否為題目要求字符，是的話要更新當前區間狀態及有效字符串數量
                if (required.containsKey(d)) {
                    if (intervalState.get(d).equals(required.get(d))) valid--;
                    intervalState.put(d, intervalState.get(d) - 1);
                }
                left++;
            }
        }

        return false;
    }
}
