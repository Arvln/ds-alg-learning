package questions.array.s710;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int size;
    Map<Integer, Integer> blackToWhiteNumber;

    public Solution(int n, int[] blacklist) {
        size=n-blacklist.length;
        blackToWhiteNumber=new HashMap<>();
        for (int b : blacklist) blackToWhiteNumber.put(b, 63);

        int last=n-1;
        for (int b : blacklist) {
            if (b >= size) continue;
            while (blackToWhiteNumber.containsKey(last)) last--;

            blackToWhiteNumber.put(b, last);
            last--;
        }
    }

    public int pick() {
        int number = (int) (Math.random()*size);

        if (blackToWhiteNumber.containsKey(number)) {
            return blackToWhiteNumber.get(number);
        }

        return number;
    }
}
