class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int [numCourses];

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        int [] output = new int [numCourses];
        int idx = 0;

        while(!queue.isEmpty()){
            int index = queue.poll();
            output[idx] = index;
            idx++;
            for (int neigh : adj.get(index)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }
            }

        }

        return idx == numCourses ? output : new int[] {};
        
    }
}
