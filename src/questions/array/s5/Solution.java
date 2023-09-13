package questions.array.s5;

public class Solution {
    private static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l+1, r);
    }

    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = palindrome(s, i, i);
            String even = palindrome(s, i, i+1);

            result = result.length() < odd.length() ? odd : result;
            result = result.length() < even.length() ? even : result;
        }

        return result;
    }
}
