package practices.backtrack.s37;

public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }
    boolean dfs(char[][] board, int i, int j)
    {
        if (i==9) return true;
        if (j==9) return dfs(board, i+1, 0);
        if (board[i][j]!='.') return dfs(board, i, j+1);

        for (char c='1'; c<='9'; c++)
        {
            if (!isValid(board, i, j, c)) continue;

            board[i][j]=c;
            if (dfs(board, i, j+1)) return true;
            board[i][j]='.';
        }

        return false;
    }
    boolean isValid(char[][] board, int row, int col, char c)
    {
        for (int i=0; i<9; i++)
            if(board[i][col]==c) return false;

        for (int j=0; j<9; j++)
            if (board[row][j]==c) return false;

        int x=row/3*3, y=col/3*3;
        for (int p=0; p<3; p++)
            for (int q=0; q<3; q++)
                if (board[x+p][y+q]==c) return false;

        return true;
    }
}
