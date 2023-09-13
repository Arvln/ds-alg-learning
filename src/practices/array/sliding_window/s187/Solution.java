package practices.array.sliding_window.s187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences1(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        int left=0, right=0;
        while (right<s.length()) {
            right++;

            if (right-left==10) {
                String c = s.substring(left, right);
                if (set.contains(c)) result.add(c);
                set.add(s.substring(left, right));
                left++;
            }
        }

        return new ArrayList<>(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);

        int[] hashList = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            hashList[i]=map.get(s.charAt(i));
        }

        HashSet<Integer> records = new HashSet<>();
        HashSet<String> result = new HashSet<>();

        int left=0, right=0, hash=0;
        while (right<s.length()) {
            hash=hash*4+hashList[right];
            right++;

            if (right-left==10) {
                if (records.contains(hash)) result.add(s.substring(left, right));
                records.add(hash);
                hash=hash-hashList[left]*(int)Math.pow(4, 10-1);
                left++;
            }
        }

        return new ArrayList<>(result);
    }
    /**
     * 返回所有在 s 中出现不止一次的 长度为 10 的序列(子字符串)
     *
     * tips
     * 1, 判斷字符串是否相同可以使用哈希加密字串
     * 2, 結合滑動窗口就是滑動哈希技巧
     *
     * */
}
