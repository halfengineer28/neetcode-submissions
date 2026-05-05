class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : count) {
            if (freq > 0) {
                pq.add(freq);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!queue.isEmpty() || !pq.isEmpty()) {
            time++;

            if (pq.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int poll = pq.poll() - 1;
                if(poll > 0){
                    queue.add(new int[] {poll, time + n});

                }
                
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.poll()[0]);
            }
        }
        return time;
    }
}
