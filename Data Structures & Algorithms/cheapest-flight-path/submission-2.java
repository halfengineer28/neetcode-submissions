class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0],x ->  new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.add(new int [] {0, src, 0});

        int [] stops = new int [n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!heap.isEmpty()){
            int [] cell = heap.poll();
            int stop = cell[2];
            int cost = cell[0];
            int city = cell[1];

            if (city == dst){
                return cost;
            }

            if (stop > k){
                continue;

            }
            if (stop >= stops[city]){
                continue;
            }
            stops[city] = stop;
            for (int [] cities : map.getOrDefault(city, new ArrayList<>())){
                heap.add(new int [] {cost + cities[1], cities[0], stop + 1});
            }
        }
        return -1;

    }
}
