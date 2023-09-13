package questions.backtrack.s694;

import java.util.HashSet;

public class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m=grid.length;
        if (m==0) return 0;
        int n=grid[0].length;

        HashSet<String> track=new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]!=1) continue;

                StringBuilder sb = new StringBuilder();
                backtrack(grid, sb, i, j, 63);
                track.add(sb.toString());
            }
        }
        return track.size();
    }

    private void backtrack(int[][] grid, StringBuilder sb, int i, int j, int dir) {
        int m=grid.length, n=grid[0].length;
        if (i<0||j<0||i>=m||j>=n) return;
        if (grid[i][j]!=1) return;

        grid[i][j]=2;
        sb.append(dir).append(",");
        backtrack(grid, sb, i-1, j, 1);
        backtrack(grid, sb, i+1, j, 2);
        backtrack(grid, sb, i, j-1, 3);
        backtrack(grid, sb, i, j+1, 4);
        sb.append(-dir).append(",");
    }
}
