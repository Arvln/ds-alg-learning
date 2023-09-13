package questions.bfs.s752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> blacklist=new HashSet<>(), visited=new HashSet<>();
        for (String deadend : deadends) blacklist.add(deadend);

        Queue<String> q=new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step=0;
        while(!q.isEmpty()) {
            int size=q.size();

            for(int i=0; i<size; i++) {
                String cur=q.poll();

                if (blacklist.contains(cur)) continue;
                if (target.equals(cur)) return step;

                for (int j=0; j<4; j++) {
                    String up=up(cur, j);
                    String down=down(cur, j);

                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String up(String s, int i) {
        char[] c=s.toCharArray();

        if (c[i]=='9') c[i]='0';
        else c[i]++;
        return new String(c);
    }
    private String down(String s, int i) {
        char[] c=s.toCharArray();

        if (c[i]=='0') c[i]='9';
        else c[i]--;
        return new String(c);
    }
}
