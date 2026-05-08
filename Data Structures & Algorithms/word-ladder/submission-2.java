class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (beginWord.equals(endWord)){
            return 1;

        }
        if (!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 1;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                String word = queue.poll();
                char [] copy = word.toCharArray();
                for (int j = 0; j < copy.length; j++){
                    char ch = copy[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        copy[j] = c;
                        String newWord = new String(copy);
                        if (newWord.equals(endWord)){
                            return res + 1;
                        }
                        if (wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    copy[j] = ch;
                    
                }
              
            }
            res++;
            
        }
        return 0;
        
    }
}
