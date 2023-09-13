package questions.math.bit.s389;

public class Solution {
    public char findTheDifference(String s, String t) {
        int res=t.charAt(t.length()-1);
        for (int i=0; i<s.length(); i++) {
            res^=s.charAt(i)^t.charAt(i);
        }
        return (char) res;
    }
}
