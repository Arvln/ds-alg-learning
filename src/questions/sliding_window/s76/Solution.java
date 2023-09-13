package questions.sliding_window.s76;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        // 初始化題目要求的字符及對應數量 { [key: char]: [value: 數量] }
        // 初始化區間內字符及對應數量的狀態 { [key: char]: [value: 數量] }
        HashMap<Character, Integer> required = new HashMap<>();

        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> intervalState = new HashMap<>();

        // 初始化兩根指針, 結果子串起始索引和長度, 有效字串個數
        int left = 0; int right = 0;
        int start = 0; int len = Integer.MAX_VALUE;
        int valid = 0;
        // 遍歷字串, 題目要求的字符進入區間後更新區間狀態和有效字串數量
        while (right < s.length()) {
            // 獲取即將加入區間字符
            char c = s.charAt(right);
            // 字符是題目要求的字符的話更新區間狀態
            if (required.containsKey(c)) {
                intervalState.put(c, intervalState.getOrDefault(c, 0) + 1);
                // 如果區間狀態滿足題目要求增加有效字符數量
                if (intervalState.get(c).equals(required.get(c))) valid++;
            }
            right++;

            // 完成加入字符後，檢查是否所有字符都滿足題目要求，滿足後開始收緊區間
            while (left < right && valid == required.size()) {
                char d = s.charAt(left);

                // 判斷即將移出區間字符是否是題目要求字符，是的話要更新區間狀態
                if (required.containsKey(d)) {
                    // 如果區間狀態滿足題目要求減少有效字符數量
                    if (intervalState.get(d).equals(required.get(d))) valid--;
                    intervalState.put(d, intervalState.get(d) - 1);
                }

                // 檢查當前區間大小是否比結果字串的長度小，比較小要跟新結果字串起始索引跟長度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                left++;
            }
        }

        // 判斷字串長度是否是整數最大值，是的話就是沒找到，反之就是結果
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
