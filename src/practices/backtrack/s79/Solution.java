package practices.backtrack.s79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if (m==0) return false;
        int n=board[0].length;

        for (int i=0; i<m; i++)
            for (int j=0; j<n; j++)
                if (dfs(board, word, i, j, 0)) return true;
        return false;
    }
    boolean dfs(char[][] board, String word, int i, int j, int p)
    {
        int m=board.length, n=board[0].length;
        if (p==word.length()) return true;
        if (i<0||j<0||i>=m||j>=n) return false;
        if (board[i][j]!=word.charAt(p)) return false;

        char c=board[i][j];
        board[i][j]='.';
        boolean top=dfs(board, word, i-1, j, p+1);
        boolean down=dfs(board, word, i+1, j, p+1);
        boolean left=dfs(board, word, i, j-1, p+1);
        boolean right=dfs(board, word, i, j+1, p+1);
        board[i][j]=c;
        return top||down||left||right;
    }
}
