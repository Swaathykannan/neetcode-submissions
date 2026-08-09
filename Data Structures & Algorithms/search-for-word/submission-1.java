class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean isExist = dfs(board, word, i, j, 0,new boolean[board.length][board[0].length]);
                    if (isExist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index,boolean[][] inUse) {
        if (index == word.length()) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }
        if (word.charAt(index) == board[row][col] && !inUse[row][col]) {
            inUse[row][col]=true;
            for (int[] direction : DIRECTIONS) {
                boolean result =
                    dfs(board, word, row + direction[0], col + direction[1], index + 1,inUse);
                if (result)
                    return true;
            }
            inUse[row][col]=false;
        }
        return false;
    }
}
