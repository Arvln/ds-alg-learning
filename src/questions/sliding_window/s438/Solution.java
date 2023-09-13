package questions.sliding_window.s438;

import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 初始化題目要求字符及對應數量的哈希表 { [key: char]: [value: int] }
        // 初始化區間字符及對應數量的狀態
        // 初始化結果數組
        HashMap<Character, Integer> required = new HashMap<>();
        for (char c : p.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> intervalState = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 初始化左右指針、有效字符數量
        int left = 0; int right = 0;
        int valid = 0;

        // 遍歷目標字串
        while (right < s.length()) {
            // 獲取即將加入的字符
            char c = s.charAt(right);

            // 比對是否是題目要求字符，是的話更新區間狀態、有效字符數量
            if (required.containsKey(c)) {
                intervalState.put(c, intervalState.getOrDefault(c, 0) + 1);
                // 如果區間字符數等於題目要求字符數，視作有效字符，有效字符數+1
                if (intervalState.get(c).equals(required.get(c))) valid++;
            }
            right++;

            // 如果區間大小大於等於題目字符長度收緊區間
            while (left < right && right - left >= p.length()) {
                // 檢查是否有效字符數等於題目要求字符長度，將左指針加入到結果數組中
                if (valid == required.size()) result.add(left);
                // 獲取即將移出區間字符
                char d = s.charAt(left);

                // 比對是否是題目要求字符，是的話更新區間狀態、有效字符數量
                if (required.containsKey(d)) {
                    // 如果區間字符數等於題目要求字符數，視作有效字符，有效字符數-1
                    if (intervalState.get(d).equals(required.get(d))) valid--;
                    intervalState.put(d, intervalState.get(d) - 1);
                }
                left++;
            }
        }

        return result;
    }
}
