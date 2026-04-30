class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> store = new HashMap<>();

        for (String s : strs){
            char [] Schararray = s.toCharArray();
            Arrays.sort(Schararray);
            String newString = new String(Schararray);
            store.putIfAbsent(newString, new ArrayList<>());
            store.get(newString).add(s);

        }

        return new ArrayList<>(store.values());
        
    }
}
