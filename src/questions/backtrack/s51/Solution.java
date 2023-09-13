package questions.backtrack.s51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> res=new ArrayList<>();
    private int n;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        ArrayList<String> board=new ArrayList<>();
        for (int i=0; i<n; i++) {
            /**board.add(".".repeat(n));*/
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(ArrayList<String> board, int row) {
        if (row==board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        for (int col=0; col<n; col++) {
            if (!isValid(board, row, col)) continue;

            StringBuilder sb=new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            backtrack(board, row+1);

            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    private boolean isValid(ArrayList<String> board, int row, int col) {
        for (int i=row-1; i>=0; i--) {
            if (board.get(i).charAt(col)=='Q') return false;
        }

        for (int i=row-1, j=col-1; i>=0&&j>=0; i--, j--) {
            if (board.get(i).charAt(j)=='Q') return false;
        }

        for (int i=row-1, j=col+1; i>=0&&j<n; i--, j++) {
            if (board.get(i).charAt(j)=='Q') return false;
        }

        return true;
    }
}
