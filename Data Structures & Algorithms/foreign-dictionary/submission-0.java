class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            char[] wchar = word.toCharArray();
            for (int i = 0; i < wchar.length; i++) {
                map.putIfAbsent(wchar[i], new HashSet<>());
                indegree.putIfAbsent(wchar[i], 0);
            }
        }

        for (int i = 0; i < words.length -1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLength = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
               
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);

            for (char c : map.get(ch)) {
                indegree.put(c, indegree.get(c) - 1);
                    if (indegree.get(c) == 0) {
                        queue.add(c);
                    }
                
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
