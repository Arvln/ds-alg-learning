package practices.array.two_pointer.s9;

public class Solution {
    public static boolean isPalindrome1(int x) {
        if (x<0) return false;

        String s = Integer.toString(x);

        int left=0, right=s.length()-1;
        while (left<right) {
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        int tmp = x;
        int y = 0;
        while (tmp > 0) {
            int last = tmp % 10;
            tmp = tmp / 10;
            y = y*10 + last;
        }

        return y==x;
    }
}
