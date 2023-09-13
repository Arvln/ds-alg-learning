package practices.array.two_pointer.s125;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int left=0, right=s.length()-1;
        while (left<right) {
            if (s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
