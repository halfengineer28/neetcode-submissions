class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        int [] vis = new int [n];

        for (int i = 0; i < n; i++){
            ans.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            ans.get(edge[0]).add(edge[1]);
            ans.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (vis[i] != 1){
                count++;
                dfs(vis, ans, i );
            }
        }
        return count;

    }
    public void dfs(int [] vis, List<List<Integer>> ans, int i){
        Queue <Integer> queue = new LinkedList<>();
        queue.add(i);
        vis[i] = 1;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            for (int adj : ans.get(poll)){
                if (vis[adj] != 1){
                    vis[adj] = 1;
                    queue.add(adj);
                }
            }
        }
        
    }
}
