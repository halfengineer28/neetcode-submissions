class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1){
            return false;
        }
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        set.add(0);
        queue.add(new int []{0, -1});

        while (!queue.isEmpty()){
            int [] poll = queue.poll();
            int node = poll[0];
            int parent = poll[1];

            for (int neigh : adj.get(node)){
                if (neigh == parent){
                    continue;
                }
                if (set.contains(neigh)){
                    return false;
                }
                set.add(neigh);
                queue.add(new int []{neigh, node});
            }
        }
        return set.size() == n;
    }
}
