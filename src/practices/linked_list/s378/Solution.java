package practices.linked_list.s378;

import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);

        for (int i = 0; i < matrix[0].length; i++) {
            pq.offer(new int[]{0, i});
        }
        int res=matrix[0][0];
        while (!pq.isEmpty() && k>0) {
            int[] poll = pq.poll();
            int i=poll[0];
            int j=poll[1];
            res=matrix[i][j];
            k--;
            if (i+1<matrix.length) {
                pq.offer(new int[]{i+1, j});
            }
        }
        return res;
    }
}
