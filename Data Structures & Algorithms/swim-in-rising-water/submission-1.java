class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int [n][m];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        heap.add(new int[] {grid[0][0], 0, 0});
        vis[0][0] = 1;

        while (!heap.isEmpty()) {
            int [] cell = heap.poll();
            int time = cell[0];
            int r = cell[1];
            int c = cell[2];
            if (r == n-1 && c == m-1){
                return time;
            }

            int[] rows = new int[] {-1, 0, 1, 0};
            int[] cols = new int[] {0, 1, 0, -1};

            for (int i = 0; i < 4; i++) {
                int nrow = r + rows[i];
                int ncol = c + cols[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1) {
                    vis[nrow][ncol] = 1;
                    heap.add(new int[] {Math.max(time, grid[nrow][ncol]), nrow, ncol});
                }
            }
        }
         return n*m;
    }
  
}
