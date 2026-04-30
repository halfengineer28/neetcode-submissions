class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int cnt = map.size();
        int need = 0;

        HashMap<Character, Integer> smap = new HashMap<>();

        while (r < s2.length()) {
            char ch = s2.charAt(r);
            if (map.containsKey(ch)) {
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
                if (smap.get(ch) == map.get(ch)) {
                    need++;
                }
            }

            while ((r - l + 1) > s1.length()) {
                char c = s2.charAt(l);
                if (smap.containsKey(c)){
                    if (smap.get(c).equals(map.get(c))){
                        need--;
                    }
                    smap.put(c, smap.get(c)-1);
                }
                l++;
            }

            if (cnt == need){
                return true;
            }
            r++;
        }
        return false;
    }
}
