class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String result = "";
        if (!map.containsKey(key)) {
            return result;
        }

        List<Pair<String, Integer>> store = map.get(key);
        int start = 0;
        int end = store.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (store.get(mid).getValue() <= timestamp) {
                result = store.get(mid).getKey();
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
