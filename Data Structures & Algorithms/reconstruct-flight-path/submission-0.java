class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).add(ticket.get(1));
        }
        

        dfs("JFK");
        return result;

    }
    public void dfs(String str){
        PriorityQueue<String> neighbors = map.get(str);
        while(neighbors != null && !neighbors.isEmpty()){
            dfs(neighbors.poll());
        }
        result.addFirst(str);

    }
}
