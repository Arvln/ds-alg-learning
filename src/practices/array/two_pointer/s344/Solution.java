package practices.array.two_pointer.s344;

public class Solution {
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        while (left<right) {
            char tmp = s[left];
            s[left]=s[right];
            s[right]=tmp;
            left++;
            right--;
        }
    }
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出
     *
     * tips
     * 1, 左右指針相向而行
     *
     * */
}
