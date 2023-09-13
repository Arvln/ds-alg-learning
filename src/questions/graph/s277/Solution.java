package questions.graph.s277;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    private boolean knows(int a, int b) {
        return true;
    }

    public int findCelebrity(int n) {
        int cand=0;

        for (int other=1; other<n; other++) {
            if (knows(cand, other)||!knows(other, cand)) {
                cand=other;
            }
        }

        Collections.reverse(new LinkedList<>());

        for (int other=0; other<n; other++) {
            if (cand==other) continue;
            if (knows(cand, other)||!knows(other, cand)) return -1;
        }

        return cand;
    }
}
