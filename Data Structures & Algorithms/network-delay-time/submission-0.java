class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            map.computeIfAbsent(time[0], 
            x -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.add(new int []{0, k});

        Map<Integer, Integer> visited = new HashMap<>();
        while(!heap.isEmpty()){
            int [] cell = heap.poll();
            int node = cell[1]; int time = cell[0];

            if (visited.containsKey(node)){
                continue;
            }

            visited.put(node, time);
            if (!map.containsKey(node)){ continue;}
            for (int [] adj : map.get(node)){
                int nextNode = adj[0];
                int cost = adj[1];
                if (!visited.containsKey(nextNode)){
                    heap.add(new int [] {cost + time, nextNode});
                }
            }
        }
        if(visited.size() != n) {
            return -1;
        }
        return Collections.max(visited.values());
    }
}
