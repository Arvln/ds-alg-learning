package practices.array.two_pointer.s5;

public class Solution {
    private String palindrome(String s, int left, int right) {
        char[] c = s.toCharArray();

        while (left>=0 && right<s.length() && c[left] == c[right]) {
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }

    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = palindrome(s, i, i);
            String even = palindrome(s, i, i+1);

            result = odd.length() > result.length() ? odd : result;
            result = even.length() > result.length() ? even : result;
        }

        return result;
    }
    /**
     * 找到 s 中最长的回文子串
     *
     * tips
     * 1, 遍歷數組中元素，並以元素為中心計算最大的迴文字串
     *
     * */
}
