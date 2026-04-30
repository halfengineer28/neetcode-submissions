class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs){
            char [] schar = str.toCharArray();
            Arrays.sort(schar);
            String s = new String(schar);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);

        }

        List<List<String>> ans = new ArrayList<>(map.values());
      
        return ans;
        
    }
}
