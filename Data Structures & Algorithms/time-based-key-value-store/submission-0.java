class TimeMap {
    Map<String , List<Pair <Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));   
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!keyStore.containsKey(key)){
            return res;
        }
        List<Pair<Integer, String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int l = 0; 
        int r = values.size()-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(values.get(mid).getKey() <= timestamp){
                res = values.get(mid).getValue();
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return res;
        
    }
}
