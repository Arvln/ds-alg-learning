package questions.bfs.s773;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<2; i++) {
            for (int j=0; j<3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start=sb.toString();

        int[][] neighbor=new int[][]{
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}
        };
        HashSet<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int step=0;
        while(!q.isEmpty()) {
            int size=q.size();
            for (int i=0; i<size; i++) {
                String cur=q.poll();

                if ("123450".equals(cur)) return step;

                int zeroIndex=0;
                for (; cur.charAt(zeroIndex)!='0'; zeroIndex++);
                for (int adj : neighbor[zeroIndex]) {
                    String next=swapChars(cur, adj, zeroIndex);

                    if (visited.contains(next)) continue;

                    q.offer(next);
                    visited.add(next);
                }
            }
            step++;
        }
        return -1;
    }
    private String swapChars(String s, int i, int j) {
        char[] c=s.toCharArray();
        char tmp=c[i];
        c[i]=c[j];
        c[j]=tmp;
        return new String(c);
    }
}
