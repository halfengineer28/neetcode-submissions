class Solution {
    public String minWindow(String s, String t) {
        ///1  store freq of t string  to get the size of elem need to find in s string
        /// apply variable size sliding window;
        // if condition matches shrink the window to get min length

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character,Integer> smap = new HashMap<>();

        for (char ch : t.toCharArray()){
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int need = tmap.size();

        int l = 0;
        int r = 0;
        int have = 0;
        int minlen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while(r < s.length()){
            char ch = s.charAt(r);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) && tmap.get(ch).equals(smap.get(ch))){
                have++;
            }

            while(have == need){
                if (minlen > (r- l +1 )){
                    minlen = r-l+1;
                    start = l;
                    end = r;

                }
                char c = s.charAt(l);
                smap.put(c, smap.get(c)-1);
                if(tmap.containsKey(c) && smap.get(c) < tmap.get(c)){
                    have--;
                }
                l++;
            }
            r++;

        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, end+1);
        
    }
}
