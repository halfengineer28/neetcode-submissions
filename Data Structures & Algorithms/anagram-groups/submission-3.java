class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs){

            char [] st = str.toCharArray();
            Arrays.sort(st);
            String check = new String(st);
            map.putIfAbsent(check, new ArrayList<>());
            map.get(check).add(str);
            
            

        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
      
    }
}
