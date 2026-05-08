class Solution {
    int [] parent;
    int [] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
         parent = new int[n + 1];
         rank = new int[n + 1];

        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;

        }
        for (int [] edge : edges){
            if (!union(edge[0], edge[1])){
                return new int []{edge[0], edge[1]};
            }
        }
        return new int []{-1, -1};
    }
    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
             
        }
        return parent[x];
    }
    public boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if (px == py){
            return false;
        } 
        if (rank[px] > rank[py]){
            parent[py] = px;
            rank[px] += rank[py];

        }else{
            parent[px] = py;
            rank[py] += rank[px];
        }
        return true;
    }
}
