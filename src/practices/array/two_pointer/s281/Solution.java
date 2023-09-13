package practices.array.two_pointer.s281;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> v1, v2;
    int left=0, right=0;

    public Solution(List<Integer> v1, List<Integer> v2) {
        this.v1=v1;
        this.v2=v2;
    }

    public int next() {
        int result;

        if (left<v1.size() && left<=right){
            result=v1.get(left);
            left++;
        } else {
            result=v2.get(right);
            right++;
        }

        return result;
    }

    public boolean hasNext() {
        return left<v1.size() || right<v2.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        for (int i = 1; i < 3; i++) v1.add(i);
        for (int i = 3; i < 7; i++) v2.add(i);

        Solution s = new Solution(v1, v2);
        while (s.hasNext()) System.out.println(s.next());
    }
}
