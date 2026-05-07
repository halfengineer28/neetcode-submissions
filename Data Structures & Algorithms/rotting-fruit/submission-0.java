class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int minutes = 0;
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                int[] rows = new int[] {-1, 0, 1, 0};
                int[] cols = new int[] {0, 1, 0,  - 1};
                for (int j = 0; j < 4; j++){
                    int nrow = r + rows[j];
                    int ncol = c + cols[j];
                    if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        queue.add(new int [] {nrow, ncol});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }

}
