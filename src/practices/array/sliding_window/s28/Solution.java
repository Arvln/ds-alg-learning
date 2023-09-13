package practices.array.sliding_window.s28;

public class Solution {
    public int strStr(String haystack, String needle) {
        int left=0, right=0;
        while (right<haystack.length()) {
            right++;

            if (right-left==needle.length()) {
                if (haystack.substring(left, right).equals(needle)) return left;
                left++;
            }
        }
        return -1;
    }
}
