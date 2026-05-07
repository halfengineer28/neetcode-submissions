class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            int[] row = new int[] {-1, 0, 1, 0};
            int[] col = new int[] {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int newr = r + row[i];

                int newc = c + col[i];

                if (newr >= 0 && newr < grid.length && newc >= 0 && newc < grid[0].length
                    && grid[newr][newc] == Integer.MAX_VALUE) {
                        grid[newr][newc] = grid[r][c] + 1;
                        queue.add(new int []{newr, newc});
                }
            }
        }
    }
}
