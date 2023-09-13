package practices.backtrack.s51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> board=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        for (int i=0; i<n; i++) {
            /**board.add(".".repeat(n));*/
        }
        backtrack(board, 0, res);
        return res;
    }
    private void backtrack(ArrayList<String> board, int i, List<List<String>> res) {
        if (i==board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        String row=board.get(i);
        StringBuilder sb=new StringBuilder(row);
        for (int j=0; j<row.length(); j++) {
            if (!isValid(board, i, j)) continue;
            if (row.charAt(j)!='.') continue;

            sb.setCharAt(j, 'Q');
            board.set(i, sb.toString());
            backtrack(board, i+1, res);
            sb.setCharAt(j, '.');
            board.set(i, sb.toString());
        }
    }
    private boolean isValid(ArrayList<String> board, int r, int c) {
        int n=board.size();
        for (int i=r; i>=0; i--) {
            if (board.get(i).charAt(c)=='Q') return false;
        }
        for (int i=r, j=c; i>=0&&j>=0; i--, j--) {
            if (board.get(i).charAt(j)=='Q') return false;
        }
        for (int i=r, j=c; i>=0&&j<n; i--, j++) {
            if (board.get(i).charAt(j)=='Q') return false;
        }
        return true;
    }
}
