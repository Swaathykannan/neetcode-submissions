class Solution {
    public int uniquePaths(int m, int n) {
        int paths[][] = new int[m][n];
        for(int[] row:paths){
            Arrays.fill(row,0);
        }
        return findUniquePaths(m, n, m-1, n-1, paths);
    }

    private int findUniquePaths(int m, int n, int row, int col, int[][] paths) {
        if (row == 0 || col == 0) {
            return 1;
        }
        if(paths[row][col]!=0){
            return paths[row][col];
        }
        paths[row][col]=findUniquePaths(m, n, row-1, col, paths)+findUniquePaths(m, n, row, col-1, paths);
        return paths[row][col];
    }
}
