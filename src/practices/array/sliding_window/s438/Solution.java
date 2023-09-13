package practices.array.sliding_window.s438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char w = p.charAt(i);
            need.put(w, need.getOrDefault(w, 0)+1);
        }

        int left=0, right=0, valid=0;
        while (right<s.length()) {
            char c = s.charAt(right);

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).equals(window.get(c))) valid++;
            }
            right++;

            if (right-left>p.length()) {
                char d = s.charAt(left);

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) valid--;
                    window.put(d, window.get(d)-1);
                }

                left++;
            }
            if (valid==need.size()) result.add(left);
        }

        return result;
    }
    /**
     *  返回特定异位词所有子串的起始索引
     *
     * tips
     * 1, 異位詞即為各個字符個數總數相等
     * 2, 統計[left..right)內各個字符總數
     * 3, 字數等於異位詞長度可右移左界
     * 4, 每次右移右界檢查是否所有字符數量結正確並更新結果
     *
     * */
}
